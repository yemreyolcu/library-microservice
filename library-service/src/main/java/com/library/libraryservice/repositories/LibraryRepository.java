package com.library.libraryservice.repositories;

import com.library.libraryservice.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface LibraryRepository extends JpaRepository<Library, UUID> {
}