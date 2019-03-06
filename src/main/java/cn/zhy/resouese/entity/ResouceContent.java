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
public class ResouceContent implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  private String title;
  private String summary;
  private Date addTime;
  private String seoKeyword;
  private String seoDescription;
  private String thumbnailImg;
  private Integer clickCount;
  private String author;
  private Integer isShow;
  private Integer isHome;
  private Integer isNews;
  private Integer catalogId;
  private Integer siteType;
  private Integer isRecommend;
  private String description;
  private String classPid;
  // 资源分类
  @TableField(exist = false)
  private ResouceCatalog resouceCatalog;
  // 视频
  @TableField(exist = false)
  private List<ResouceVideo> resouceVideo;
  // 文件
  @TableField(exist = false)
  private ResouceDownloadFile resouceDownloadFile;
}
