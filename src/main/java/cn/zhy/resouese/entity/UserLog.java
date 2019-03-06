package cn.zhy.resouese.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author admin
 * @since 2018-11-09
 */
@Data
@AllArgsConstructor
public class UserLog implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  private Long userId;
  private String ip;
  private String address;
  private String content;
  private Date addTime;

  public UserLog() {}

  public UserLog(Long userId, String ip, String address, String content, Date addTime) {
    this.userId = userId;
    this.ip = ip;
    this.address = address;
    this.content = content;
    this.addTime = addTime;
  }
}
