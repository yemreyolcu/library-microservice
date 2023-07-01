package com.user.userservice.entities;
import javax.persistence.*;
import lombok.*;
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(schema = "public", name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

}
