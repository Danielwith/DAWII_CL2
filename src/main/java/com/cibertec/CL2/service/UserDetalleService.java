package com.cibertec.CL2.service;

import com.cibertec.CL2.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetalleService implements UserDetailsService {
    @Autowired
    private UserService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.buscarUsuarioPorNomusuario(username);
        return usuarioPorAutenticacion(usuario,
                obtenerAutorizacionUsuario());
    }

    private List<GrantedAuthority> obtenerAutorizacionUsuario() {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("ADMIN"));
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails usuarioPorAutenticacion(Usuario usuario,
                                                List<GrantedAuthority> authorityList) {
        return new User(usuario.getNomUsuario(), usuario.getPassUsuario(),
                true, true, true, true, authorityList);
    }
}
