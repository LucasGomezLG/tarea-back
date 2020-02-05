package com.example.democrud.model.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.democrud.model.src.Tarea;

public class TareaTest {

	private Tarea tarea;

	@Before
	private void setup() {

		tarea = new Tarea("Tarea 1", "TAREAUNO", "Alta");

	}

	@Test
	private void testTareaNombreIgualNombre() {

		assertEquals(tarea.getNombre(), "Tarea 1");
	    assertFalse(tarea.getNombre().isEmpty());
	}
	
	@Test
	private void testTareaDescIgualDesc() {
		
		assertEquals(tarea.getDescripcion(), "TAREAUNO");
		assertFalse(tarea.getDescripcion().isEmpty());
	}
	
	@Test
	private void testTareaNuevaCeroActividades() {
		
		assertTrue(tarea.getActividades().isEmpty());
		
	}
	
	
	
}
