package com.example.democrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String tarea;
	
	private String descripcion;
	
	private String prioridad;
	
	private StateTarea stateTarea;
	

}
