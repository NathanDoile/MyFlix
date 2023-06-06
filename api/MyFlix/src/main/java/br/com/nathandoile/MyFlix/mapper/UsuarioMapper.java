package br.com.nathandoile.MyFlix.mapper;

import br.com.nathandoile.MyFlix.controller.request.CadastrarUsuarioRequest;
import br.com.nathandoile.MyFlix.controller.response.UsuarioResponse;
import br.com.nathandoile.MyFlix.domain.Usuario;

public class UsuarioMapper {

    private UsuarioMapper() {
    }

    public static Usuario toEntity(CadastrarUsuarioRequest request){

        return Usuario
                .builder()
                .nome(request.getNome())
                .senha(request.getSenha())
                .dataNascimento(request.getDataNascimento())
                .email(request.getEmail())
                .build();
    }

    public static UsuarioResponse toResponse(Usuario entity) {

        return UsuarioResponse
                .builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .dataNascimento(entity.getDataNascimento())
                .build();
    }
}