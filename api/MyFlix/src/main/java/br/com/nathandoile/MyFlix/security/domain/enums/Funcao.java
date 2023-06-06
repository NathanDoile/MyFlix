package br.com.nathandoile.MyFlix.security.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Funcao {

    USUARIO(Nomes.USUARIO),
    ADMIN(Nomes.ADMIN);

    public static class Nomes {

        private Nomes() {
        }

        public static final String USUARIO = "ROLE_USUARIO";
        public static final String ADMIN = "ROLE_ADMIN";
    }

    private final String role;
}