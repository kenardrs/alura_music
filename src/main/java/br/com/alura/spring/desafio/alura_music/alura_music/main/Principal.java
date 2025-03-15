package br.com.alura.spring.desafio.alura_music.alura_music.main;

import br.com.alura.spring.desafio.alura_music.alura_music.entities.Artista;
import br.com.alura.spring.desafio.alura_music.alura_music.entities.Musica;
import br.com.alura.spring.desafio.alura_music.alura_music.entities.TipoArtista;
import br.com.alura.spring.desafio.alura_music.alura_music.services.ArtistaService;
import br.com.alura.spring.desafio.alura_music.alura_music.services.MusicaService;

import java.util.List;
import java.util.Scanner;

public class Principal {

    private final ArtistaService artistaService;

    private final MusicaService musicaService;

    public Principal(ArtistaService artistaService, MusicaService musicaService) {
        this.artistaService = artistaService;
        this.musicaService = musicaService;
    }

    private final Scanner leitura = new Scanner(System.in);

    public void exibeMenu(){
        var opcao = -1;
        while (opcao != 9) {
            var menu="""
                    Escolha uma opção do menu:
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    5- Pesquisar dados sobre um artista
                    9- Sair
                    """;
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    pesquisarDadosSobreUmArtista();
                    break;
                case 9:
                    System.out.println("Saindo... bye");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        }
    }

    private void cadastrarArtista() {
        System.out.println("Informe o nome do Artista:");
        var nome = leitura.nextLine();
        System.out.println("Escolha o tipo do Artista (SOLO, DUPLA, BANDA):");
        var tipo = leitura.nextLine().toUpperCase();

        Artista artista = new Artista();
        artista.setNome(nome);
        artista.setTipo(TipoArtista.valueOf(tipo));
        artistaService.salvarArtista(artista);
        System.out.println("Artista salvo com sucesso!");
    }

    private void cadastrarMusica() {
        System.out.println("Informe o título da Música");
        var titulo = leitura.nextLine();
        System.out.println("Informe o código de um dos artistas:");
        listarArtistas();
        var artistaId = leitura.nextLong();
        leitura.nextLine(); // buffer clean
        Musica musica = new Musica();
        musica.setTitulo(titulo);
        musicaService.salvarMusica(musica, artistaId);
        System.out.println("Música cadastrada com sucesso!");


    }

    private void listarMusicas() {
        var musicas = musicaService.listarMusicas();
        musicas.forEach(System.out::println);
    }

    private void buscarMusicasPorArtista() {
        listarArtistas();
        System.out.println("Informe o código do artista:");
        Long artistaId = leitura.nextLong();
        leitura.nextLine(); // clear buffer
        List<Musica> musicas = musicaService.listarMusicasPorArtista(artistaId);
        if (musicas.isEmpty()){
            System.out.println("O artista não possui músicas");
        } else {
            musicas.forEach(System.out::println);
        }
    }

    private void pesquisarDadosSobreUmArtista() {

    }

    private void listarArtistas() {
        List<Artista> artistas = artistaService.listarArtistas();
        if (artistas.isEmpty()) {
            System.out.println("Não tem artista na base ainda!");
        } else {
            artistas.forEach(System.out::println);
        }
    }
}
