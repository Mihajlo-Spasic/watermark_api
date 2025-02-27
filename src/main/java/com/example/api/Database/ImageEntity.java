package com.example.api.Database;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String filename;

    public ImageEntity(){}

    public ImageEntity(String filename) {
        this.filename = filename; 
    }
    public Long getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;  
    }
}