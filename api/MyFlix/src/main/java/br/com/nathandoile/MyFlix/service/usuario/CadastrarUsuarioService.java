package br.com.nathandoile.MyFlix.service.usuario;

import br.com.nathandoile.MyFlix.controller.request.CadastrarUsuarioRequest;
import br.com.nathandoile.MyFlix.controller.response.UsuarioResponse;
import br.com.nathandoile.MyFlix.domain.Usuario;
import br.com.nathandoile.MyFlix.repository.UsuarioRepository;
import br.com.nathandoile.MyFlix.security.domain.Permissao;
import br.com.nathandoile.MyFlix.service.validator.ValidarEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static br.com.nathandoile.MyFlix.mapper.UsuarioMapper.toEntity;
import static br.com.nathandoile.MyFlix.mapper.UsuarioMapper.toResponse;
import static br.com.nathandoile.MyFlix.security.domain.enums.Funcao.USUARIO;

@Service
public class CadastrarUsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ValidarEmailService validarEmailService;

    @Transactional
    public UsuarioResponse cadastrar(CadastrarUsuarioRequest request) {
        validarEmailService.validar(request.getEmail());

        Usuario usuario = toEntity(request);
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        usuario.setAtivo(true);
        usuario.setPermissoes(new ArrayList<>());

        Permissao permissaoPadrao = new Permissao();
        permissaoPadrao.setFuncao(USUARIO);

        usuario.adicionarPermissao(permissaoPadrao);

        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }
}
