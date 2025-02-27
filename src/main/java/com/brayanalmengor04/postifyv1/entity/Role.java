package com.brayanalmengor04.postifyv1.entity;

import com.brayanalmengor04.postifyv1.enums.Permission;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    private String roleName;
    private String description;

    private String permission;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onPersist() {
        this.createdAt = LocalDateTime.now();
    }
}
