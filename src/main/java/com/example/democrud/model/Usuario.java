package com.example.democrud.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String username;
    private String password;
    
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY ,orphanRemoval = true , cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Tarea> tareas = new ArrayList<>();

  
	public Usuario(){

    }

    public Usuario(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public Usuario(String username, String password, ArrayList<Tarea> tareas){
        this.username = username;
        this.password = password;
        this.tareas = tareas;
    }
    
    public List<Tarea> getTareas() {
  		return tareas;
  	}

  	public void setTareas(List<Tarea> tareas) {
  		this.tareas = tareas;
  	}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public void agregarTarea(Tarea tarea) {
		
		this.tareas.add(tarea);
	}
}
