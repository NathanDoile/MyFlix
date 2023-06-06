package br.com.nathandoile.MyFlix.factory;

import br.com.nathandoile.MyFlix.controller.request.CadastrarUsuarioRequest;
import br.com.nathandoile.MyFlix.domain.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioFactory {

    public static CadastrarUsuarioRequest cadastrarUsuarioRequest(){
        return CadastrarUsuarioRequest
                .builder()
                .nome("Nome de teste")
                .email("email@teste.com")
                .dataNascimento(LocalDate.of(2000, 06, 23))
                .senha("senha")
                .build();
    }

    public static Usuario usuario(){
        return Usuario
                .builder()
                .id(1L)
                .nome("Nome de teste")
                .email("email@teste.com")
                .dataNascimento(LocalDate.of(2000, 06, 23))
                .senha("senha")
                .ativo(true)
                .minhaLista(new ArrayList<>())
                .permissoes(new ArrayList<>())
                .build();
    }
}
