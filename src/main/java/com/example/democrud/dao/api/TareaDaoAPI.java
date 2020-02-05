package com.example.democrud.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.example.democrud.model.src.Tarea;

public interface TareaDaoAPI extends CrudRepository<Tarea, Long> {

}
