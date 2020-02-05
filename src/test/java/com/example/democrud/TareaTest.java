package com.example.democrud;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.democrud.model.Tarea;

public class TareaTest {

	private Tarea tarea;

	@Before
	public void setup() {

		tarea = new Tarea("Tarea 1", "TAREAUNO", "Alta");

	}

	@Test
	public void testTareaNombreIgualNombre() {

		assertEquals(tarea.getNombre(), "Tarea 1");
	    assertFalse(tarea.getNombre().isEmpty());
	}
	
	@Test
	public void testTareaDescIgualDesc() {
		
		assertEquals(tarea.getDescripcion(), "TAREAUNO");
		assertFalse(tarea.getDescripcion().isEmpty());
	}
	
	@Test
	public void testTareaNuevaCeroActividades() {
		
		assertTrue(tarea.getActividades().isEmpty());
		
	}
	
	
	
}
