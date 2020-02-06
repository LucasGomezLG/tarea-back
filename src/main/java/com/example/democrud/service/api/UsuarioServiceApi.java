package com.example.democrud.service.api;

import java.util.Optional;

import com.example.democrud.commons.GenericServiceAPI;
import com.example.democrud.model.Usuario;

import demo.example.democrud.dto.UsuarioDTO;

public interface UsuarioServiceApi extends GenericServiceAPI<Usuario,Long> {
	
	Optional<Usuario> findById(Long id);
	Usuario signup(UsuarioDTO usuarioDTO);
	Optional<Usuario> findByUsername(String usuario);
	Optional<Usuario> login(UsuarioDTO usuarioDTO);
	Usuario save(Usuario user);
}