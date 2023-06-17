package com.library.libraryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "library")
@AllArgsConstructor
@NoArgsConstructor
public class Library {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @ElementCollection
    @CollectionTable(name = "book", joinColumns = @JoinColumn(name = "library_id"))
    @Column(name = "book_id")
    private List<String> books;

}