package com.example.api.WatermarkLogic;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.filters.Caption;
import net.coobird.thumbnailator.geometry.Positions;


public class watermark_service {
   
    public String caption = "WATERMARK";
    public Font font = new Font("Monospaced", Font.PLAIN, 14);
    public Color c = Color.black;
    public Positions position = Positions.CENTER; 
    public int insetPixels = 0;
    
    public BufferedImage applyWatermark(MultipartFile file, String text) throws IOException{
        
        Caption filter;
        BufferedImage image = ImageIO.read(file.getInputStream());
        
        if (text == ""){
            filter = new Caption(caption, font, c, position, insetPixels);
        } else{
            filter = new Caption(text, font, c, position, insetPixels);
        }
        BufferedImage watermarkedImage = filter.apply(image);
     
        return watermarkedImage;
    } 
}
