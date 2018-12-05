package cn.zhy.resouese.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2018-11-09
 */
public class ResouceLableContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long contentId;
    private Long lableId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Long getLableId() {
        return lableId;
    }

    public void setLableId(Long lableId) {
        this.lableId = lableId;
    }

    @Override
    public String toString() {
        return "ResouceLableContent{" +
        ", id=" + id +
        ", contentId=" + contentId +
        ", lableId=" + lableId +
        "}";
    }
}
