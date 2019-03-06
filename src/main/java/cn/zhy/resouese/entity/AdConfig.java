package cn.zhy.resouese.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author admin
 * @since 2018-11-09
 */
@Data
public class AdConfig implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  private String name;
  private String adImg;
  private Integer isShow;
  private String remark;
  private String url;
  private Date addTime;
}
