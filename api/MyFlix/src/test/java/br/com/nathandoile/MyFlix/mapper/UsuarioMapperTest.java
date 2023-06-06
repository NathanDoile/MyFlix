package br.com.nathandoile.MyFlix.mapper;

import br.com.nathandoile.MyFlix.controller.request.CadastrarUsuarioRequest;
import br.com.nathandoile.MyFlix.controller.response.UsuarioResponse;
import br.com.nathandoile.MyFlix.domain.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.nathandoile.MyFlix.factory.UsuarioFactory.cadastrarUsuarioRequest;
import static br.com.nathandoile.MyFlix.factory.UsuarioFactory.usuario;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UsuarioMapperTest {

    @InjectMocks
    private UsuarioMapper tested;

    @Test
    @DisplayName("Deve retornar entidade corretamente quando request válido")
    void deveRetornarEntidadeCorretamenteQuandoRequestValido(){
        CadastrarUsuarioRequest request = cadastrarUsuarioRequest();

        Usuario response = tested.toEntity(request);

        assertEquals(request.getNome(), response.getNome());
        assertEquals(request.getEmail(), response.getEmail());
        assertEquals(request.getDataNascimento(), response.getDataNascimento());
        assertEquals(request.getSenha(), response.getSenha());
    }

    @Test
    @DisplayName("Deve retornar response corretamente quando usuário válido")
    void deveRetornarResponseCorretamenteQuandoRequestValido(){
        Usuario usuario = usuario();

        UsuarioResponse response = tested.toResponse(usuario);

        assertEquals(usuario.getId(), response.getId());
        assertEquals(usuario.getNome(), response.getNome());
        assertEquals(usuario.getEmail(), response.getEmail());
        assertEquals(usuario.getDataNascimento(), response.getDataNascimento());
    }
}
