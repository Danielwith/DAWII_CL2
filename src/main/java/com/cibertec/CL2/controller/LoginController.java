package com.cibertec.CL2.controller;

import com.cibertec.CL2.entity.Usuario;
import com.cibertec.CL2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private UserService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "auth/frmLogin";
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "auth/frmRegistroUsuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.guardarUsuario(usuario);
        return "auth/frmLogin";
    }
}
