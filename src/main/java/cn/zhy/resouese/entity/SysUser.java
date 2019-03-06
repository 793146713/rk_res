package cn.zhy.resouese.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author admin
 * @since 2018-11-09
 */
@Data
public class SysUser implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  private String username;
  private String password;
  private Date addTime;
  private Date lastLoginTime;
  private Integer status;
  private String headerImg;
  private String remark;
  private String email;
  private String code;

  @TableField(exist = false)
  private List<SysRole> sysRole;
}
