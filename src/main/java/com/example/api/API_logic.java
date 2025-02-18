package com.example.api;

import java.io.IOException;
import java.nio.file.Files;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Services.ImageService;



@RestController
@RequestMapping("/watermark")
public class API_logic {

    private ImageService imageService;


    @PostMapping({"/upload", "/upload/{text}", "/upload/force/{text}","/upload/{text}/{oppacity}"})
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file,
                                              @PathVariable(required = false) String force,
                                              @PathVariable(required = false) String text,
                                              @PathVariable(required = false) int opacity) {

        if(file.isEmpty()) {
            return ResponseEntity.badRequest()
                                 .body("[BAD REQUEST] File not sent");
        }
        if ( (force != "force") && (imageService.checkFileExistence(file)) ){
            return ResponseEntity.badRequest()
                                 .body("[BAD REQUEST] File with the same name already exists. Use `force` to change the previous entry");
        } 

       imageService.queueEntity(file);

        System.out.println("Received file: " + file.getOriginalFilename());
        return ResponseEntity.accepted().build();
    }   

    @GetMapping("/{retrived_picture}")
    public ResponseEntity<byte[]> watermark_image() throws IOException{
        Resource imageResource = new ClassPathResource("uploads/");
        byte[] imageBytes = Files.readAllBytes(imageResource.getFile().toPath());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", Files.probeContentType(imageResource.getFile().toPath()));

        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.valueOf("image/png"))
                             .body(imageBytes);

    }
}
