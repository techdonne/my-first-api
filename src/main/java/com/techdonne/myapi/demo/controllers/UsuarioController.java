package com.techdonne.myapi.demo.controllers;

import com.techdonne.myapi.demo.entities.Usuario;
import com.techdonne.myapi.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
