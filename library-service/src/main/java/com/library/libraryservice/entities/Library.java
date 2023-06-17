package com.library.libraryservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "library")
public class Library {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @ElementCollection
    @CollectionTable(name = "book", joinColumns = @JoinColumn(name = "library_id"))
    @Column(name = "book_id")
    private List<String> books;

}