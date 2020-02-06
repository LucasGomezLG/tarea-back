package com.example.democrud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.democrud.model.Tarea;
import com.example.democrud.model.Usuario;
import com.example.democrud.service.api.TareaServiceApi;
import com.example.democrud.service.api.UsuarioServiceApi;

import demo.example.democrud.dto.TareaDto;

@CrossOrigin
@RestController
public class TareaRestController {
	
	@Autowired
	private TareaServiceApi tareaServiceApi;
	
	@Autowired
	private UsuarioServiceApi usuarioServiceApi;

	@RequestMapping(method = RequestMethod.GET, value ="/tareas")
	public ResponseEntity getTareas() {
		
		return new ResponseEntity <>(tareaServiceApi.getAll(), HttpStatus.OK);
		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/tarea/{id}")
	public ResponseEntity get(@PathVariable Long id ){

		Tarea tarea = tareaServiceApi.get(id);
		return new ResponseEntity <>( tarea , HttpStatus.OK);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, value ="/tarea/{id}"  )
	public ResponseEntity deleteTarea(@PathVariable Long id ) {
		tareaServiceApi.delete(id);
		return new ResponseEntity <> ("Delete: " + id ,HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/addtarea")
	public ResponseEntity addTarea(@RequestBody TareaDto tareaNueva) {
		
		
		Optional<Usuario> maybeUsuario = usuarioServiceApi.findById(tareaNueva.getIdUsuario());
		
		if(! maybeUsuario.isPresent()) {
			return new ResponseEntity<>("Please log in",HttpStatus.UNAUTHORIZED);
		}
		Tarea newTarea = tareaNueva.parseTarea();
		newTarea.setUsuario(maybeUsuario.get());
		
		return new ResponseEntity<>(tareaServiceApi.save(newTarea), HttpStatus.OK);
		
	}
	
	
	
}
