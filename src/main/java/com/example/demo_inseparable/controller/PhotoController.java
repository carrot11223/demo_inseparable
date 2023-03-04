package com.example.demo_inseparable.controller;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.example.demo_inseparable.pojo.TablePhoto;
import com.example.demo_inseparable.service.TablePhotoService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 图片处理接口
 *
 * @author carrot
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
      return tablePhotoService.savePhoto(file, request);
    }


    /**
     * 实现文件下载
     *
     * @param keyword 输入的关键字
     * @param model
     */
    @GetMapping("/download")
    public String download(@RequestParam("keyword") String keyword, ModelMap model) {
      //返回所有图片的相对路径
      List<String> photos = tablePhotoService.getPhoto(keyword);


      model.addAttribute("images", photos);
      return "search";
    }


}






