package com.example.Services;
import com.example.api.Database.ImageEntity;
import com.example.api.Database.ImageRepository;
import com.example.api.WatermarkLogic.watermark_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
@Service
public class ImageService {
    private watermark_service watermark;
    private String image_directory = "original_image/";

    @Autowired
    private ImageRepository imageRepo;

    public ImageEntity saveFilename(String filename){
        return imageRepo.save(new ImageEntity(image_directory + filename));
    }

    public Optional<ImageEntity> findByFilename(String ImagePath){
        return imageRepo.findByFilename(ImagePath);
    }

    public boolean fileExists(MultipartFile file){
        Optional<ImageEntity> exists = findByFilename(file.getOriginalFilename());

        if(exists.isPresent()){
            return true;
        }
        return false;
    }

    public void queueEntity(MultipartFile file, String text, int opacity) throws IOException{
        
        //implement special queue singleton/static class 
        byte[] watermarked_image = watermark.applyWatermark(file.getBytes(), text, opacity);

        
    };
}