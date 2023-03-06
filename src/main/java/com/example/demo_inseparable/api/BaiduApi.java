package com.example.demo_inseparable.api;

import com.baidu.aip.util.Base64Util;
import com.example.demo_inseparable.utils.FileUtil;
import com.example.demo_inseparable.utils.HttpUtil;

import java.net.URLEncoder;

import static com.example.demo_inseparable.constant.ImgConstant.TOKEN;
import static com.example.demo_inseparable.constant.ImgConstant.URL;
/**
 * 通用物体和场景识别
 */

public class BaiduApi {

    public static String advancedGeneral(String imgUrl) {
        try {
            // 本地文件路径
            String filePath = imgUrl;
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam;
            String result = HttpUtil.post(URL, TOKEN, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}