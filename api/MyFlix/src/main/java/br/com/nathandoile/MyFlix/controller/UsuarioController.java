package br.com.nathandoile.MyFlix.controller;

import br.com.nathandoile.MyFlix.controller.request.CadastrarUsuarioRequest;
import br.com.nathandoile.MyFlix.controller.response.UsuarioResponse;
import br.com.nathandoile.MyFlix.service.usuario.CadastrarUsuarioService;
import br.com.nathandoile.MyFlix.service.usuario.DeletarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private CadastrarUsuarioService cadastrarUsuarioService;

    @Autowired
    private DeletarUsuarioService deletarUsuarioService;

    @PostMapping
    @ResponseStatus(CREATED)
    public UsuarioResponse cadastrar(@RequestBody CadastrarUsuarioRequest request){
        return cadastrarUsuarioService.cadastrar(request);
    }

    @Secured("ROLE_USUARIO")
    @DeleteMapping
    @ResponseStatus(OK)
    public void deletar(){
        deletarUsuarioService.deletar();
    }
}
