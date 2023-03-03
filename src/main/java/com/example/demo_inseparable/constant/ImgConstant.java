package com.example.demo_inseparable.constant;

/**
 * 百度接口当中用到的常量
 *
 * @author
 */
public class ImgConstant {
    // 请求url
    public static final String URL =  "https://aip.baidubce.com/rest/2.0/image-classify/v2/advanced_general";

    // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
    public static final String TOKEN = "24.52e8d73b9661b20f0a00c7fce1932c42.2592000.1680444196.282335-30742657";

}
