package com.techdonne.myapi.demo.services;

import com.techdonne.myapi.demo.dto.UsuarioResponseDTO;
import com.techdonne.myapi.demo.entities.Usuario;
import com.techdonne.myapi.demo.repositories.UsuarioRepository;
import com.techdonne.myapi.demo.services.exceptions.UsuarioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Transactional
    public Usuario findById(Integer id){
        Optional<Usuario> obj =  usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new UsuarioException("Objeto não encontrado Id: " + id + ", Tipo " + Usuario.class.getName()));
    }
    @Transactional
    public List<UsuarioResponseDTO> findAll(){
        List<Usuario> obj = usuarioRepository.findAll();
        return obj.stream().map(x -> new UsuarioResponseDTO(x)).toList();
    }
}
