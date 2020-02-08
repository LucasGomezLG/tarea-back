package com.example.democrud.controller;

import com.example.democrud.model.Tarea;
import com.example.democrud.service.api.ActividadServiceApi;
import com.example.democrud.service.api.TareaServiceApi;
import com.example.democrud.service.api.UsuarioServiceApi;
import demo.example.democrud.dto.TareaContenidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ActividadesController {

    @Autowired
    private ActividadServiceApi actividadService;

    @Autowired
    private UsuarioServiceApi usuarioService;

    @Autowired
    private TareaServiceApi tareaService;

    @PostMapping("actividades/add")
    public ResponseEntity cargarActividades(@RequestBody TareaContenidoDTO tareaContenidoDTO){

        Optional<Tarea> maybeTarea = tareaService.findById(tareaContenidoDTO.getIdTarea());

        if(! maybeTarea.isPresent() ){
            return new ResponseEntity<>("Tarea no encontra3",HttpStatus.NOT_FOUND);
        }
        tareaContenidoDTO.getActividades().forEach(a -> a.setTarea(maybeTarea.get()));

        actividadService.saveAll(tareaContenidoDTO.getActividades());

        return new ResponseEntity<>("Ok",HttpStatus.OK);
    }
}
