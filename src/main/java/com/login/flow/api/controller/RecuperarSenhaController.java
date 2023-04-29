package com.login.flow.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.flow.api.model.Usuario;
import com.login.flow.api.repository.UsuarioRepository;

@RestController
public class RecuperarSenhaController {
    
    
        @Autowired
        private UsuarioRepository usuarioRepository;
    
        @PostMapping(value = "/senha")
        public Object recuperaSenha (@RequestBody Usuario usuario) {
            String email = usuario.getEmail();
            
                      
            Optional<Usuario> usuarioBD = usuarioRepository.findByEmail(email);
            

            if (usuarioBD.isEmpty()) {
                return "Usuario não cadastrado";
            }

            return usuarioBD.get();

               
        
    }
}
