package br.com.alura.spring.desafio.alura_music.alura_music.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "artista")
@Data
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoArtista tipo;

    @OneToMany(mappedBy = "artista", fetch = FetchType.EAGER)
    @ToString.Exclude // evita estouro de pilha
    private List<Musica> musicas;

}
