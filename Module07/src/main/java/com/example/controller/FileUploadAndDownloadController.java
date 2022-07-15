package com.example.controller;

/*
    @author syrio
    @date 2022/6/16
    @time 17:31
    @description 文件上传/下载控制器 测试文件的上传与下载
*/

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class FileUploadAndDownloadController {

    /*测试文件下载*/
    @GetMapping("/testFileDownload")
    @ResponseBody
    public ResponseEntity<byte[]> testFileDownload(HttpSession session) throws IOException {

        String realPath = session.getServletContext().getRealPath("/static/file/Florence + The Machine - Stand By Me.mp3");
        InputStream inputStream = new FileInputStream(realPath);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=Florence + The Machine - Stand By Me.mp3");

        HttpStatus status = HttpStatus.OK;

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes, headers, status);

        inputStream.close();
        return responseEntity;
    }

    /*测试文件上传*/
    @PostMapping("/testFileUpload")
    public ModelAndView testFileUpload(ModelAndView mav, MultipartFile file, HttpSession session) throws IOException {
        /*获取存储上传文件的文件夹路径*/
        String fileUploadedPath = session.getServletContext().getRealPath("fileUploaded");
        File fileUploaded = new File(fileUploadedPath);
        /*如果不存在则创建*/
        if (!fileUploaded.exists()) {
            fileUploaded.mkdir();
        }

        /*上传文件的原名*/
        String fileName = file.getOriginalFilename();
        /*获取文件名后缀*/
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        /*使用uuid作为文件名来解决文件重名问题*/
        String uuid = UUID.randomUUID().toString();
        /*拼接uuid与后缀作为文件的最终名称*/
        fileName = uuid + suffix;

        /*上传文件的最终存储路径*/
        String finalPath = fileUploadedPath + File.separator + fileName;
        file.transferTo(new File(finalPath));
        mav.addObject("result", "testFileUpload： " + finalPath);
        mav.setViewName("success");
        return mav;
    }

}
