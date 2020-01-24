package com.example.democrud.dao.api;

import com.example.democrud.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioDaoApi extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findByUsernameAndPassword(String username, String password);

    Optional<Usuario> findByUsername(String usuario);
}
