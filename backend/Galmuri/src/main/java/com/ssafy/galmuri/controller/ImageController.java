package com.ssafy.galmuri.controller;

import com.ssafy.galmuri.service.AmazonS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/image")
public class ImageController {
    private final AmazonS3Service imageService;

    @PostMapping("/upload")
    public String uploadImage(@RequestPart(value = "file") MultipartFile file){
        try{
            return imageService.uploadFile(file);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

}
