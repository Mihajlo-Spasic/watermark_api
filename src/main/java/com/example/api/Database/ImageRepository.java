package com.example.api.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    
    Optional<ImageEntity> findByFilename(String filename);
    Optional<ImageEntity> findByImagePath(String imagepath);
}
