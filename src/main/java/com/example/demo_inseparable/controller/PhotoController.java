package com.example.demo_inseparable.controller;

import com.example.demo_inseparable.api.BaiduApi;
import com.example.demo_inseparable.service.TablePhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * 图片逻辑处理类
 */

@Controller
@RequestMapping("/common")
public class PhotoController {
@Autowired
  TablePhotoService tablePhotoService;

    /**
     * 文件上传
     *
     * @param file 上传的文件
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {//此处的file是一个临时文件，请求消失之后就会不见，我们要把这个文件放到我们的服务器上面
        Integer id = tablePhotoService.savePhoto(file, request);
        return "上传成功 -->" + id.toString();
    }


    /**
     * 实现文件下载
     *
     * @param keyword 输入的关键字
     * @param response
     */
    @GetMapping("/download")
    public void download(@RequestParam("keyword") String keyword, HttpServletResponse response) {
    tablePhotoService.getPhoto(keyword,response);
    }
}






