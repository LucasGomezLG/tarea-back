package com.example.democrud.service.iml;

import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.api.UsuarioDaoApi;
import com.example.democrud.model.src.Usuario;
import com.example.democrud.service.api.UsuarioServiceApi;
import demo.example.democrud.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService  extends GenericServiceImpl<Usuario, Long> implements UsuarioServiceApi {

    @Autowired
    private UsuarioDaoApi usuarioDaoApi;

    @Override
    public CrudRepository<Usuario, Long> getDao() {
        return usuarioDaoApi;
    }

    public Optional<Usuario> login(UsuarioDTO usuarioDTO){
       return usuarioDaoApi.findByUsernameAndPassword(usuarioDTO.getUsername(),usuarioDTO.getPassword());
    }

    public Optional<Usuario> findByUsername(String usuario) {
        return usuarioDaoApi.findByUsername(usuario);
    }

    public Usuario signup(UsuarioDTO usuarioDTO){
        return usuarioDaoApi.save(new Usuario(usuarioDTO.getUsername(),usuarioDTO.getPassword()));
    }

    public Optional<Usuario> findById(Long id){
        return usuarioDaoApi.findById(id);
    }
    
    public Usuario save(Usuario user) {
    	return usuarioDaoApi.save(user);
    }
}
