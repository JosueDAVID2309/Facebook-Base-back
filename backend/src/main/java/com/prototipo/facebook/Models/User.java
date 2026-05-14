package com.prototipo.facebook.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Data
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String nombres;

    @Column(nullable=false)
    private String apellidos;

    @Column(nullable=false)
    private String genero;

    @Column(nullable = false)
    private LocalDate f_nacimiento;

    @Column(nullable = true)
    private String imageurl;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String clave;

    @OneToMany(mappedBy = "author")
    private List<Post> publicaciones = new ArrayList<>();;

    @OneToMany(mappedBy = "user")
    private List<Reaction> likes;

    @OneToMany(mappedBy = "author")
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(
        name = "followers",
        joinColumns = @JoinColumn(name = "follower_id"),
        inverseJoinColumns = @JoinColumn(name = "following_id")
    )
    private List<User> following = new ArrayList<>();

    @ManyToMany(mappedBy = "following")
    private List<User> followers = new ArrayList<>();
}
