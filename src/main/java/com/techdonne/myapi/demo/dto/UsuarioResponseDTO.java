package com.techdonne.myapi.demo.dto;

import com.techdonne.myapi.demo.entities.Usuario;

public record UsuarioResponseDTO(Integer id, String nome, String login, String senha) {
    public UsuarioResponseDTO (Usuario usuario){
        this (usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getSenha());
    }
}
