package com.example.democrud.controller;

import com.example.democrud.service.api.ActividadServiceApi;
import com.example.democrud.service.api.TareaServiceApi;
import com.example.democrud.service.api.UsuarioServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
public class CoreController {

    @Autowired
    private TareaServiceApi tareaServiceApi;

    @Autowired
    private UsuarioServiceApi usuarioServiceApi;

    @Autowired
    private ActividadServiceApi actividadServiceApi;

    @RequestMapping(method = RequestMethod.GET, value ="/dropAll")
    public ResponseEntity dropDatabase(@RequestParam HashMap<String,String> params){

        String user =params.get("u");
        String password = params.get("p");
        if(! (user.equals("admin") && password.equals("admin1234"))){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        usuarioServiceApi.deleteAll();
        tareaServiceApi.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }
}
