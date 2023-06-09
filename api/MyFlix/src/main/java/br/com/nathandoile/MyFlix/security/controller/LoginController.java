package br.com.nathandoile.MyFlix.security.controller;

import br.com.nathandoile.MyFlix.controller.response.UsuarioResponse;
import br.com.nathandoile.MyFlix.security.service.BuscarUsuarioLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private BuscarUsuarioLoginService buscarUsuarioLoginService;

    @PostMapping
    public UsuarioResponse login() {
        return buscarUsuarioLoginService.buscar();
    }
}