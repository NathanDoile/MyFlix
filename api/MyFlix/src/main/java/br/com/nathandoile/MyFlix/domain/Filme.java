package br.com.nathandoile.MyFlix.domain;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Filme {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    @Type(type="org.hibernate.type.ImageType")
    private byte[] banner;

    @ManyToMany(cascade = REMOVE)
    @JoinTable(name = "usuario_filme",
            joinColumns = @JoinColumn(name = "id_filme"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario"))
    private List<Usuario> usuarios = new ArrayList<>();

    @ManyToMany(cascade = REMOVE)
    @JoinTable(name = "ator_filme",
            joinColumns = @JoinColumn(name = "id_filme"),
            inverseJoinColumns = @JoinColumn(name = "id_ator"))
    private List<Ator> elenco = new ArrayList<>();

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "id_diretor")
    private Diretor diretor;
}