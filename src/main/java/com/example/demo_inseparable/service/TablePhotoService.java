package com.example.demo_inseparable.service;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.example.demo_inseparable.pojo.TablePhoto;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 图片处理接口
 *
 * @author carrot
 */
public interface TablePhotoService extends IService<TablePhoto> {
    /**
     * 根据关键字获取图片
     *
     * @param keyword 搜索的关键字
     * @return
     */
    List<String> getPhoto(String keyword);

    /**
     * 保存图片
     *
     * @param file
     * @param request
     */
    String savePhoto(MultipartFile file, HttpServletRequest request) throws IOException;
}
