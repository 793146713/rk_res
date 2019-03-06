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
public class SiteConfig implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  private String siteName;
  private String seoKeyword;
  private String seoDescription;
  private String siteQuotation;
  private String aboutSummary;
  private String aboutDashang;
  private String aboutErweima;
}
