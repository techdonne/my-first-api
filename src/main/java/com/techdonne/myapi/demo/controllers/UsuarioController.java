package com.techdonne.myapi.demo.controllers;

import com.techdonne.myapi.demo.dto.UsuarioResponseDTO;
import com.techdonne.myapi.demo.entities.Usuario;
import com.techdonne.myapi.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping(value= "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id){
        Usuario obj = usuarioService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public List<UsuarioResponseDTO> findAll(){
        return usuarioService.findAll();
    }

    @PutMapping(value = "/{id}")
    public UsuarioResponseDTO update(@PathVariable Integer id, @RequestBody Usuario usuario){
        return usuarioService.update(id, usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        UsuarioResponseDTO newUsuario = usuarioService.create(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newUsuario.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
