package com.example.democrud.controller;

import com.example.democrud.model.Usuario;
import com.example.democrud.service.iml.UsuarioService;
import demo.example.democrud.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Optional;

@CrossOrigin
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.POST, value ="/login")
    public ResponseEntity login(@RequestBody UsuarioDTO usuarioDTO) {

        Optional<Usuario> maybeUser = usuarioService.login(usuarioDTO);
        if(! maybeUser.isPresent()){
            return new ResponseEntity<>("Please, login",HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(maybeUser.get(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value ="/signup")
    public ResponseEntity signup(@RequestBody UsuarioDTO usuarioDTO) {

        if(! usuarioDTO.hasValidData()){
            return new ResponseEntity<>("Error data request", HttpStatus.BAD_REQUEST);
        }

        Optional<Usuario> maybeUser = usuarioService.findByUsername(usuarioDTO.getUsername());
        if(maybeUser.isPresent()){
            return new ResponseEntity<>("Please choose another username", HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(usuarioService.signup(usuarioDTO),HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public ResponseEntity getUsuario(@RequestParam HashMap<String,String> param){

        long userId;
        try{
            userId = Long.parseLong(param.get("id"));
        }catch(Exception e){
            return new ResponseEntity<>("Wrong query parameters", HttpStatus.BAD_REQUEST);
        }

        Optional<Usuario> maybeUser = this.usuarioService.findById(userId);

        if(! maybeUser.isPresent()){
            return new ResponseEntity<>("User does not exist",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(maybeUser.get(), HttpStatus.OK);
    }
}
