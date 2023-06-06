package br.com.nathandoile.MyFlix.service.usuario;

import br.com.nathandoile.MyFlix.controller.request.CadastrarUsuarioRequest;
import br.com.nathandoile.MyFlix.controller.response.UsuarioResponse;
import br.com.nathandoile.MyFlix.domain.Usuario;
import br.com.nathandoile.MyFlix.repository.UsuarioRepository;
import br.com.nathandoile.MyFlix.service.validator.ValidarEmailService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import static br.com.nathandoile.MyFlix.factory.UsuarioFactory.cadastrarUsuarioRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CadastrarUsuarioServiceTest {

    @InjectMocks
    private CadastrarUsuarioService tested;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private ValidarEmailService validarEmailService;

    @Test
    @DisplayName("Deve retornar response corretamente quando request válido")
    void deveRetornarResponseCorretamenteQuandoRequestValido(){
        CadastrarUsuarioRequest request = cadastrarUsuarioRequest();

        when(passwordEncoder.encode(request.getSenha())).thenReturn(request.getSenha());

        UsuarioResponse response = tested.cadastrar(request);

        verify(validarEmailService).validar(request.getEmail());
        verify(passwordEncoder).encode(request.getSenha());
        verify(usuarioRepository).save(any(Usuario.class));

        assertEquals(request.getNome(), response.getNome());
        assertEquals(request.getEmail(), response.getEmail());
        assertEquals(request.getDataNascimento(), response.getDataNascimento());
    }

    @Test
    @DisplayName("Deve retornar erro quando e-mail inválido")
    void deveRetornarErroQuandoEmailInvalido(){
        CadastrarUsuarioRequest request = cadastrarUsuarioRequest();

        doThrow(ResponseStatusException.class).when(validarEmailService).validar(request.getEmail());

        assertThrows(ResponseStatusException.class, () -> tested.cadastrar(request));

        verify(validarEmailService).validar(request.getEmail());
        verify(passwordEncoder, never()).encode(request.getSenha());
        verify(usuarioRepository, never()).save(any(Usuario.class));
    }
}
