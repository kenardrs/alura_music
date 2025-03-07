package br.com.alura.spring.desafio.alura_music.alura_music.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "musica")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    private Artista artista;

}
