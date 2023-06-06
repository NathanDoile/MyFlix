package br.com.nathandoile.MyFlix.security.domain;

import br.com.nathandoile.MyFlix.domain.Usuario;
import br.com.nathandoile.MyFlix.security.domain.enums.Funcao;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter @ToString(of = "id")
public class Permissao {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Enumerated(STRING)
    private Funcao funcao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}