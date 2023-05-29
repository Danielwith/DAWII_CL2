package com.cibertec.CL2.service;

import com.cibertec.CL2.entity.Usuario;
import com.cibertec.CL2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository usuarioRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder
            = new BCryptPasswordEncoder();

    public Usuario buscarUsuarioPorNomusuario(String nomUsuario) {
        return usuarioRepository.findByNomUsuario(nomUsuario);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        usuario.setPassUsuario(bCryptPasswordEncoder
                .encode(usuario.getPassUsuario()));
        return usuarioRepository.save(usuario);
    }
}
