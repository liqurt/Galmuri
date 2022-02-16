package com.ssafy.galmuri.controller;

import com.ssafy.galmuri.dto.flag.FlagDto;
import com.ssafy.galmuri.service.AmazonS3Service;
import com.ssafy.galmuri.service.FlagService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
@RequestMapping("/image")
public class ImageController {
    private final AmazonS3Service imageService;
    private final FlagService flagService;

    @PostMapping("/upload")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file){
        try{
            return imageService.uploadFile(file);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    @PostMapping("/upload/{countryCode}")
    public String uploadImage(@RequestPart(value = "file") MultipartFile file,@PathVariable String countryCode){
        try{
            String url=imageService.uploadFile(file);
            flagService.save(new FlagDto(countryCode,url));
            return url;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }


}
