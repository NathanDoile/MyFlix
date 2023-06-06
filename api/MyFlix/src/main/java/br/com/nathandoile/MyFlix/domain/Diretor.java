package br.com.nathandoile.MyFlix.domain;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Diretor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nomeCompleto;

    private LocalDate dataNascimento;

    private String resumoHistoria;

    @Type(type="org.hibernate.type.ImageType")
    private byte[] foto;

    @OneToMany(mappedBy = "diretor", cascade = ALL)
    private List<Filme> filmes = new ArrayList<>();
}