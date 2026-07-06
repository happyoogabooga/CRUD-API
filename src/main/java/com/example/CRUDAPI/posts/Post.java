package com.example.CRUDAPI.posts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Character")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long characterid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String race;
    
    @Column(nullable = false)
    private String universe;

    public Post(String name, String description, String race, String universe){
        this.name = name;
        this.description = description;
        this.race = race;
        this.universe = universe;
    }
}
