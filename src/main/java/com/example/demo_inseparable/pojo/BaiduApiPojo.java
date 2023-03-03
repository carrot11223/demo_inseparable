package com.example.demo_inseparable.pojo;

import java.util.List;

/**
 * 百度接口返回的json转换为对象
 *
 * @author carrot
 */
public class BaiduApiPojo {


    /**
     * 示例：
     * result_num : 5
     * result : [{"keyword":"屏幕截图","score":0.603201,"root":"非自然图像-屏幕截图"},{"keyword":"图像素材","score":0.476867,"root":"非自然图像-图像素材"},{"keyword":"箭头","score":0.335731,"root":"商品-军火"},{"keyword":"图标","score":0.16803,"root":"非自然图像-图像素材"},{"keyword":"旗帜","score":0.008813,"root":"商品-旗帜"}]
     * log_id : 1631669036365826058
     */

    private int result_num;
    private long log_id;
    private List<ResultBean> result;

    public int getResult_num() {
        return result_num;
    }

    public void setResult_num(int result_num) {
        this.result_num = result_num;
    }

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }


}
