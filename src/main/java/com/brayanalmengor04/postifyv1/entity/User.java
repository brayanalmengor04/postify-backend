package com.brayanalmengor04.postifyv1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String streetAddress;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = true)  // Clave foránea
    private Role role;

}
