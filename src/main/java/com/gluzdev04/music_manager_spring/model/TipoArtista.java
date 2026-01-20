package com.gluzdev04.music_manager_spring.model;

public enum TipoArtista {
    SOLO("solo"),
    DUPLA("dupla"),
    BANDA("banda");

    private String tipoArtista;

    TipoArtista(String tipoArtista) {
        this.tipoArtista = tipoArtista;
    }

    public static TipoArtista fromEnum(String text) {
        for (TipoArtista tipoArtista : TipoArtista.values()) {
            if (tipoArtista.tipoArtista.equalsIgnoreCase(text)) {
                return tipoArtista;
            }
        }
        throw new IllegalArgumentException("Nenhum tipo de artista encontrado para o tipo escolhido: " + text);
    }
}
