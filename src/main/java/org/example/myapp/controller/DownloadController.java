package org.example.myapp.controller;


import org.example.myapp.utils.AppInfo;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Controller
public class DownloadController {
    //https://localhost//downloadhospitalimg/filename/xxxx
    @GetMapping("/downloadImg/{filename}")
    public ResponseEntity downloadImg(@PathVariable("filename") String filename) throws IOException {
        String filePath= AppInfo.FileRootPath+filename;
        FileSystemResource fileSystemResource=new FileSystemResource(filePath);
        return getResponseEntity(fileSystemResource);
    }


    private ResponseEntity<InputStreamResource> getResponseEntity(FileSystemResource file) throws IOException {
        //设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }
}
