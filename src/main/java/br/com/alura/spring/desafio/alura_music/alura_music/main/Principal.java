package br.com.alura.spring.desafio.alura_music.alura_music.main;

import java.util.Scanner;

public class Principal {

    private final Scanner leitura = new Scanner(System.in);

    public void exibeMenu(){
        var Opcao = -1;
        while (Opcao != 9) {
            System.out.println("""
                    Escolha uma opção do menu:
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    5- Pesquisar dados sobre um artista
                    9- Sair
                    """);
            Opcao = leitura.nextInt();

            switch (Opcao){
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
        System.out.println("Cadastrar artista");
    }

    private void cadastrarMusica() {
        System.out.println("Cadastrar musica");
    }

    private void listarMusicas() {
        System.out.println("Listar musicas");
    }

    private void buscarMusicasPorArtista() {
        System.out.println("Buscar musicas por artista");
    }

    private void pesquisarDadosSobreUmArtista() {

    }
}
