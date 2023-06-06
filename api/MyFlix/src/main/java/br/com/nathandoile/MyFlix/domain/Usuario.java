package br.com.nathandoile.MyFlix.domain;

import br.com.nathandoile.MyFlix.security.domain.Permissao;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private LocalDate dataNascimento;

    private String senha;

    private boolean ativo;

    @ManyToMany(mappedBy = "usuarios", cascade = REMOVE)
    private List<Filme> minhaLista = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = ALL, fetch = EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuario(this);
    }
}