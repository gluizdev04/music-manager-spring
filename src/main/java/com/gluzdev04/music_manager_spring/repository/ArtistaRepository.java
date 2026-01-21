package com.gluzdev04.music_manager_spring.repository;

import com.gluzdev04.music_manager_spring.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ArtistaRepository extends JpaRepository <Artista, Long> {
    @Query("SELECT a FROM Artista a WHERE a.nome ILIKE :nomeArtista")
    public Optional<Artista> buscarArtistaPorNome(String nomeArtista);
}
