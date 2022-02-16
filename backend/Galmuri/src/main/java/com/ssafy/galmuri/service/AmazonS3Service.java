package com.ssafy.galmuri.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@RequiredArgsConstructor
@Service
public class AmazonS3Service {
    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    public String uploadFile(MultipartFile file) throws Exception{
        if(file.isEmpty()) throw new Exception("빈 파일입니다.");
        String fileName="image/"+System.currentTimeMillis()+"_"+file.getName();

        ObjectMetadata objectMetadata=new ObjectMetadata();
        objectMetadata.setContentType(file.getContentType());


        try(InputStream inputStream=file.getInputStream()){
//            objectMetadata.setContentLength(IOUtils.toByteArray(inputStream).length);
            amazonS3Client.putObject(new PutObjectRequest(bucketName,fileName,inputStream,objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        }
        catch (IOException e){
            throw new IOException("파일 업로드에 실패하였습니다.");
        }
        return amazonS3Client.getUrl(bucketName,fileName).toString();
    }

}
