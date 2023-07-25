package com.techdonne.myapi.demo.services;

import com.techdonne.myapi.demo.entities.Usuario;
import com.techdonne.myapi.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Usuario findById(Integer id){
        Optional<Usuario> obj =  usuarioRepository.findById(id);
        return obj.orElse(null);
    }
}
