package demo.example.democrud.dto;

import com.example.democrud.model.Actividad;

public class ActividadesDTO {

	private boolean completa;
	private String descripcion;
	
	public ActividadesDTO() {
		
		
	}

	public boolean isCompleta() {
		return completa;
	}

	public void setCompleta(boolean completa) {
		this.completa = completa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	public Actividad parseActividad() {
		
		return new Actividad(this.completa , this.descripcion);
	}
	
	

	
}
