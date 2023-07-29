package com.techdonne.myapi.demo.dto;

public record UsuarioDTO(Integer id, String nome, String login, String senha) {
    public UsuarioDTO{
        this(id, nome, login, senha);
    }
}
