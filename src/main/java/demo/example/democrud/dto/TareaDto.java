package demo.example.democrud.dto;

import com.example.democrud.model.Tarea;

public class TareaDto {

	private String nombre;
	private String descripcion;
	private String prioridad;
	
	public TareaDto () {
		
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


	public Tarea parseTarea() {
		
		return new Tarea(this.nombre , this.descripcion , this.prioridad);
	}
	
	
	
}
