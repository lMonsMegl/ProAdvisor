package com.proadvisor.service;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class ImageService {
 
    @Value("#{environment.PROJECT_HOME}")
    private String PROJECT_HOME;
    
    public String save(MultipartFile multipartFile) throws IOException {
        String newFileName = RandomStringUtils.random(20, true, true) + ".jpg";
        String path = PROJECT_HOME + "/" + newFileName;
        multipartFile.transferTo(new File(path));
        return newFileName;
    }
    
    public byte[] getById(String id) {
        try(FileInputStream fileInputStream = new FileInputStream(PROJECT_HOME + "/" + id)) {
            return IOUtils.toByteArray(fileInputStream);
        } catch (IOException e) {
            return null;
        }
    }

}
