package br.com.nathandoile.MyFlix.controller.request;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
public class CadastrarUsuarioRequest {

    public static final String MENSAGEM_DE_ERRO_CAMPO_OBRIGATORIO = "é um campo obrigatório";

    @NotBlank(message = MENSAGEM_DE_ERRO_CAMPO_OBRIGATORIO)
    private String nome;

    @NotBlank(message = MENSAGEM_DE_ERRO_CAMPO_OBRIGATORIO)
    @Email
    private String email;

    @NotBlank(message = MENSAGEM_DE_ERRO_CAMPO_OBRIGATORIO)
    private LocalDate dataNascimento;

    @NotBlank(message = MENSAGEM_DE_ERRO_CAMPO_OBRIGATORIO)
    private String senha;
}
