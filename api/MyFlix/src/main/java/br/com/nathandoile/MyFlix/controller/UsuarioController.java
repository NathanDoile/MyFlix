package br.com.nathandoile.MyFlix.controller;

import br.com.nathandoile.MyFlix.controller.request.CadastrarUsuarioRequest;
import br.com.nathandoile.MyFlix.controller.response.UsuarioResponse;
import br.com.nathandoile.MyFlix.service.usuario.CadastrarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private CadastrarUsuarioService cadastrarUsuarioService;

    @PostMapping
    public UsuarioResponse cadastrar(@RequestBody CadastrarUsuarioRequest request){
        return cadastrarUsuarioService.cadastrar(request);
    }
}
