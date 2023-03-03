package com.example.demo_inseparable.pojo;
/**
 * 百度接口返回json当中的result字段的每个list属性，封装成一个对象
 *
 * @author carrot
 */
public class ResultBean {
    /**
     * 示例:
     * keyword : 屏幕截图
     * score : 0.603201
     * root : 非自然图像-屏幕截图
     */

    //关键词
    private String keyword;
    //可信度
    private double score;
    private String root;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }
}