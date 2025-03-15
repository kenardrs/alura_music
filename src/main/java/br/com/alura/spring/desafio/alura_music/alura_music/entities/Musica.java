package br.com.alura.spring.desafio.alura_music.alura_music.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "musica")
@Data
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

}
