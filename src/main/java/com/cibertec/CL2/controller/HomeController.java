package com.cibertec.CL2.controller;

import com.cibertec.CL2.entity.Usuario;
import com.cibertec.CL2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    private UserService service;
    @GetMapping("/home")
    public String home(Model model, Principal p) {
        String username = p.getName();
        Usuario user = service.buscarUsuarioPorNomusuario(username);
        model.addAttribute("USUARIO",user);
        return "home";
    }

}
