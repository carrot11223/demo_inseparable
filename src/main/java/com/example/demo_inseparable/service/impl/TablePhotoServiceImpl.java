package com.example.demo_inseparable.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo_inseparable.api.BaiduApi;
import com.example.demo_inseparable.mapper.TablePhotoMapper;
import com.example.demo_inseparable.pojo.ResultBean;
import com.example.demo_inseparable.pojo.TablePhoto;
import com.example.demo_inseparable.service.TablePhotoService;
import com.example.demo_inseparable.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * 图片处理接口实现类
 *
 * @author carrot
 */
@Service
public class TablePhotoServiceImpl extends ServiceImpl<TablePhotoMapper, TablePhoto> implements TablePhotoService {
    @Autowired
    TablePhotoMapper photoMapper;
    @Value("D:\\WorkSpace\\demo_inseparable\\demo_inseparable\\src\\main\\resources\\imgs\\")
    private String path;
    //定义拼接之后的的关键字
    String keywords = "";
    Integer id;
    String photoUrl;
    FileInputStream inputStream;
    ServletOutputStream outputStream;

    /**
     * 将图片路径以及调用百度接口返回的关键字保存到数据库
     *
     * @param file 上传的图片
     * @return 存放成功，将数据库中图片的id返回
     */
    @Override
    public String savePhoto(MultipartFile file, HttpServletRequest request) throws IOException {
       /* 此处获取的是上传文件的原始名字，但是为了防止原始的名字有重复，覆盖掉了
        原来上传的图片，所以这个时候我们使用UUID的方式上传，防止重复*/
        String originalFilename = file.getOriginalFilename();
        int i = originalFilename.lastIndexOf(".");
        String substring = originalFilename.substring(i);
        //使用 UUID的方式
        String s = UUID.randomUUID().toString();//此时生成的是一串序列，还需要拼接原始文件的后缀suffix
        String fileName = s + substring;
        File dir = new File(path);
        if (!dir.exists()) {
            //目录不存在 就创建该目录
            dir.mkdirs();
        }
        try {
            //将临时文件转存到我们设定的位置  D://+ 文件名
            file.transferTo(new File(path + fileName));
            String str = BaiduApi.advancedGeneral(path + fileName);
            JSONObject json = JSON.parseObject(str);    //先将传入的字符串转换成JSONObject
            JSONArray arr = (JSONArray) json.get("result");  //然后将3个JSON对象组成一个JSON数组

            //JSONObject jo = new JSONObject(new String(str));

            for (Object pc : arr) {
                String s1 = JsonUtils.objectToJson(pc);//遍历JSON数组，使用工具类将每个JSON对象转换成标准的字符串JSON
                ResultBean pos = JsonUtils.jsonToPojo(s1, ResultBean.class);//使用工具类将JSON字符串转换成POJO实体类（注意，这里要传入实体类.class）

                //拼接所有的关键词,存入数据库，之后用模糊查询
                keywords += pos.getKeyword();

            }


            TablePhoto tablePhoto = new TablePhoto();
            tablePhoto.setPhotoUrl(path + fileName);
            //to do 调用百度接口，返回关键字
            tablePhoto.setKeyWord(keywords);
            id = photoMapper.insert(tablePhoto);
            //session.setAttribute("resUrl", path + fileName + "上传成功photoId-->"+id);
            request.setAttribute("resUrl", "上传成功,本地路径： " + path + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //到templates/index.html页面
        return "index";
    }


    /**
     * 根据关键字获取图片
     *
     * @param keyword 关键字
     * @return 返回图片的本地路径
     */
    @Override
    public List<String> getPhoto(String keyword) {
        // 查询条件构造器
        QueryWrapper<TablePhoto> wrapper = new QueryWrapper<>();
        wrapper.like("key_word", keyword);
        // 当前的list是获取当前所有满足关键字的图片的集合
        List<TablePhoto> tablePhotos = photoMapper.selectList(wrapper);
        //pathList是所有图片的绝对路径的list集合
        List<String> pathList = tablePhotos.stream()
                .map(TablePhoto -> TablePhoto.getPhotoUrl())
                .collect(Collectors.toList());
        //准备一个存放相对路径的集合
        List<String> relativePaths = new ArrayList<>();
        for (String absolutePath : pathList) {
            String relativePath = absolutePath.replace("D:\\WorkSpace\\demo_inseparable\\demo_inseparable\\src\\main\\resources\\imgs\\", "imgs/");
            relativePaths.add(relativePath);
        }
        return relativePaths;

    }
}




