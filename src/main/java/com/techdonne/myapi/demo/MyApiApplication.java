package com.techdonne.myapi.demo;

import com.techdonne.myapi.demo.entities.Usuario;
import com.techdonne.myapi.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MyApiApplication implements CommandLineRunner {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario(null, "Daniel", "donne", "123");
		Usuario usuario2 = new Usuario(null, "Eliete", "Eli", "123");

		usuarioRepository.saveAll(Arrays.asList(usuario, usuario2));
	}
}
