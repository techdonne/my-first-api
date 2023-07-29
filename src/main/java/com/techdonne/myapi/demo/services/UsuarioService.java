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
    public UsuarioResponseDTO update(Integer id, Usuario usuario) {
        Usuario newUsuario = findById(id); //Reaproveitamento de método para pegar excessão

        newUsuario.setNome(usuario.getNome());
        newUsuario.setLogin(usuario.getLogin());
        newUsuario.setSenha(usuario.getSenha());

        return new UsuarioResponseDTO(usuarioRepository.save(newUsuario));

    }

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


    public UsuarioResponseDTO create(Usuario usuario) {
        usuario.setId(null);
        return new UsuarioResponseDTO(usuarioRepository.save(usuario));
    }

    public void delete(Integer id) {
        Usuario usuario = findById(id);
        usuarioRepository.deleteById(id);
    }
}
