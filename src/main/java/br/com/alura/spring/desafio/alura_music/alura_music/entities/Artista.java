package br.com.alura.spring.desafio.alura_music.alura_music.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artista")
@Getter
@Setter
@RequiredArgsConstructor
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    private TipoArtista tipo;

    @OneToMany(mappedBy = "artista")
    private List<Musica> musicas = new ArrayList<>();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nome = " + nome + ", " +
                "tipo = " + tipo + ")";
    }
}
