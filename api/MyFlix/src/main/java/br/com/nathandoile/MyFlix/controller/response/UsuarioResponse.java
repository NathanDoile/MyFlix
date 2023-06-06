package br.com.nathandoile.MyFlix.controller.response;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@Builder @NoArgsConstructor @AllArgsConstructor
public class UsuarioResponse {

    private Long id;

    private String nome;

    private String email;

    private LocalDate dataNascimento;
}