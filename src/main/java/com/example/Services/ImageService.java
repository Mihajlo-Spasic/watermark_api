package com.example.Services;
import com.example.api.Database.ImageEntity;
import com.example.api.Database.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class ImageService {

    private String image_directory = "original_image/";

    @Autowired
    private ImageRepository imageRepo;

    public ImageEntity saveImage(String filename){
        return imageRepo.save(new ImageEntity(image_directory + filename));
    }

    public Optional<ImageEntity> findByFilename(String ImagePath){
        return imageRepo.findByFilename(ImagePath);
    }

    public boolean checkFileExistence(MultipartFile file){return true;}
    public void queueEntity(MultipartFile file){};
}