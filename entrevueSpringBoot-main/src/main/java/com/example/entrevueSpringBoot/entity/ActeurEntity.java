package com.example.entrevueSpringBoot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ACTEURS")
public class ActeurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ID")
    @Column
    private Long id;

    @Column
    private String nom;

    @Column
    private String prenom;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_FILMS")
    private FilmEntity film;

}
