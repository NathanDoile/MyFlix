package br.com.nathandoile.MyFlix.security.service;

import br.com.nathandoile.MyFlix.controller.response.UsuarioResponse;
import br.com.nathandoile.MyFlix.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.nathandoile.MyFlix.mapper.UsuarioMapper.toResponse;

@Service
public class BuscarUsuarioLoginService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public UsuarioResponse buscar() {
        return usuarioAutenticadoService.getResponse();
    }
}