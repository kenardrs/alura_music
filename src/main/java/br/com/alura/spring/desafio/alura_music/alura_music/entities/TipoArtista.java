package br.com.alura.spring.desafio.alura_music.alura_music.entities;

public enum TipoArtista {
    SOLO,
    DUPLA,
    BANDA;

    public static boolean validaTipo(String valor) {
        for(TipoArtista tipo: TipoArtista.values()) {
            if(tipo.name().equalsIgnoreCase(valor)){
                return true;
            }
        }
        return false;
    }
}
