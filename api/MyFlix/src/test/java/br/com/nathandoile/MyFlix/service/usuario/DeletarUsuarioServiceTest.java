package br.com.nathandoile.MyFlix.service.usuario;

import br.com.nathandoile.MyFlix.domain.Usuario;
import br.com.nathandoile.MyFlix.repository.UsuarioRepository;
import br.com.nathandoile.MyFlix.security.service.UsuarioAutenticadoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.nathandoile.MyFlix.factory.UsuarioFactory.usuario;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeletarUsuarioServiceTest {

    @InjectMocks
    private DeletarUsuarioService tested;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Captor
    private ArgumentCaptor<Usuario> usuarioCaptor;

    @Test
    @DisplayName("Deve excluir logicamente o usuário corretamente quando logado")
    void deveExcluirUsuarioCorretamenteQuandoLogado(){

        Usuario usuario = usuario();

        when(usuarioAutenticadoService.get()).thenReturn(usuario);

        tested.deletar();

        verify(usuarioAutenticadoService).get();
        verify(usuarioRepository).save(usuarioCaptor.capture());

        Usuario response = usuarioCaptor.getValue();

        assertFalse(response.isAtivo());
    }
}
