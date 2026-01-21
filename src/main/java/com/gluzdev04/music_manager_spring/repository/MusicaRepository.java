package com.gluzdev04.music_manager_spring.repository;

import com.gluzdev04.music_manager_spring.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
}
