package org.example.myapp.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName equipment
 */
@TableName(value ="equipment")
@Data
public class Equipment implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer categoryId;

    /**
     * 
     */
    private String picUrl;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private Integer isLend;

    /**
     * 
     */
    private Integer isScrap;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String description;


    public Equipment(String name, Integer categoryId, String picUrl, Date date, Integer isLend, Integer isScrap, Integer userId, String description) {
        this.name = name;
        this.categoryId = categoryId;
        this.picUrl = picUrl;
        this.date = date;
        this.isLend = isLend;
        this.isScrap = isScrap;
        this.userId = userId;
        this.description = description;
    }

    public Equipment(Integer id, String name, Integer categoryId, String picUrl, Date date, Integer isLend, Integer isScrap, Integer userId, String description) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.picUrl = picUrl;
        this.date = date;
        this.isLend = isLend;
        this.isScrap = isScrap;
        this.userId = userId;
        this.description = description;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
        Equipment other = (Equipment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getIsLend() == null ? other.getIsLend() == null : this.getIsLend().equals(other.getIsLend()))
            && (this.getIsScrap() == null ? other.getIsScrap() == null : this.getIsScrap().equals(other.getIsScrap()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getIsLend() == null) ? 0 : getIsLend().hashCode());
        result = prime * result + ((getIsScrap() == null) ? 0 : getIsScrap().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", date=").append(date);
        sb.append(", isLend=").append(isLend);
        sb.append(", isScrap=").append(isScrap);
        sb.append(", userId=").append(userId);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}