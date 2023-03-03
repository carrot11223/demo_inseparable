package com.example.demo_inseparable.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 图片表
 * @TableName table_photo
 */
@TableName(value ="table_photo")
public class TablePhoto implements Serializable {
    /**
     * 图片id
     */
    @TableId(type = IdType.AUTO)
    private Byte photoId;

    /**
     * 限制大小为10k,10240个字节，1k = 1024字节（B）
     */
    private String keyWord;

    /**
     * 本地存储图片的url
     */
    private String photoUrl;

    /**
     * 图片创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 图片id
     */
    public Byte getPhotoId() {
        return photoId;
    }

    /**
     * 图片id
     */
    public void setPhotoId(Byte photoId) {
        this.photoId = photoId;
    }

    /**
     * 限制大小为10k,10240个字节，1k = 1024字节（B）
     */
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * 限制大小为10k,10240个字节，1k = 1024字节（B）
     */
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    /**
     * 本地存储图片的url
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * 本地存储图片的url
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    /**
     * 图片创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 图片创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TablePhoto other = (TablePhoto) that;
        return (this.getPhotoId() == null ? other.getPhotoId() == null : this.getPhotoId().equals(other.getPhotoId()))
            && (this.getKeyWord() == null ? other.getKeyWord() == null : this.getKeyWord().equals(other.getKeyWord()))
            && (this.getPhotoUrl() == null ? other.getPhotoUrl() == null : this.getPhotoUrl().equals(other.getPhotoUrl()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPhotoId() == null) ? 0 : getPhotoId().hashCode());
        result = prime * result + ((getKeyWord() == null) ? 0 : getKeyWord().hashCode());
        result = prime * result + ((getPhotoUrl() == null) ? 0 : getPhotoUrl().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", photoId=").append(photoId);
        sb.append(", keyWord=").append(keyWord);
        sb.append(", photoUrl=").append(photoUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}