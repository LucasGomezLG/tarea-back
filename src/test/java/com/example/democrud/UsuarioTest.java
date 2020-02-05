package com.example.democrud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.example.democrud.model.Tarea;
import com.example.democrud.model.Usuario;

public class UsuarioTest {

	private Usuario user;

	@Before
	public void setup() {

		user = new Usuario("pepe", "123");

	}

	@Test
	public void testUsuarioGetUsernamePepeMismoUsernamePepe() {

		assertEquals(user.getUsername(), "pepe");
		assertFalse(user.getUsername().isEmpty());

	}

	@Test
	public void testPasswordGetPasswordMismoString() {

		assertEquals(user.getPassword(), "123");
		assertFalse(user.getUsername().isEmpty());

	}

	@Test
	public void testUsuarioNuevoCeroTareas() {

		assertTrue(user.getTareas().isEmpty());

	}

	@Test
	public void testTareaGetTAreasMismaTarea() {

		Tarea t1 = new Tarea("Tarea 1", "TareaUno", "Alta");

		user.agregarTarea(t1);

		assertEquals(user.getTareas().get(0), t1);

		assertEquals(user.getTareas().size(), 1);

		assertFalse(user.getTareas().isEmpty());

	}

	@Test
	public void testUserNotNull() {

		assertNotNull(user);
	}

	
}
