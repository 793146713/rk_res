package cn.zhy.resouese.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * @author admin
 * @since 2018-11-09
 */
@Data
public class ResouceLableContent implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  private Long contentId;
  private Long lableId;
}
