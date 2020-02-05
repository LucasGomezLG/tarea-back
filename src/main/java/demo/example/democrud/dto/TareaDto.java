package demo.example.democrud.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.democrud.model.src.Actividad;
import com.example.democrud.model.src.Tarea;

public class TareaDto {

	private String nombre;
	private String descripcion;
	private String prioridad;
	private List<Actividad> actividades = new ArrayList<>();
	private long idUsuario;
	
	
	public TareaDto () {
		
	}
	
	

	public long getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	
	public List<Actividad> getActividades() {
		return actividades;
	}


	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}


	public Tarea parseTarea() {
		
		return new Tarea(this.nombre , this.descripcion , this.prioridad, this.actividades);
	}


	
}
