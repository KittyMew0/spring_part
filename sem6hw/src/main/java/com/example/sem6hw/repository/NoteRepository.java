package com.example.sem6hw.repository;

import com.example.sem6hw.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Optional<Note> findById(Long id);
}
