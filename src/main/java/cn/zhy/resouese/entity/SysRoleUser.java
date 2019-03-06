package cn.zhy.resouese.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author admin
 * @since 2018-11-09
 */
@Data
public class SysRoleUser implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private Integer userId;
  private Integer roleId;
}
