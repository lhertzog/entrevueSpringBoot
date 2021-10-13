package com.example.entrevueSpringBoot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "FILMS")
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ID")
    @Column
    private Long id;

    @Column
    private String titre;

    @Column
    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "film")
    private List<ActeurEntity> acteurs;

}
