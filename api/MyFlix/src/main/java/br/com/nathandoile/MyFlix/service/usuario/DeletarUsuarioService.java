package br.com.nathandoile.MyFlix.service.usuario;

import br.com.nathandoile.MyFlix.domain.Usuario;
import br.com.nathandoile.MyFlix.repository.UsuarioRepository;
import br.com.nathandoile.MyFlix.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeletarUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void deletar() {

        Usuario usuario = usuarioAutenticadoService.get();

        usuario.setAtivo(false);

        usuarioRepository.save(usuario);
    }
}
