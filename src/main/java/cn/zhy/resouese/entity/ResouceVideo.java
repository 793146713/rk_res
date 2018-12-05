package cn.zhy.resouese.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * @author admin
 * @since 2018-11-09
 */
public class ResouceVideo implements Serializable {

  private static final long serialVersionUID = 1L;
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;
  private String title;
  private String url;
  private Integer orderSort;
  private Long contentId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getOrderSort() {
    return orderSort;
  }

  public void setOrderSort(Integer orderSort) {
    this.orderSort = orderSort;
  }

  public Long getContentId() {
    return contentId;
  }

  public void setContentId(Long contentId) {
    this.contentId = contentId;
  }

  @Override
  public String toString() {
    return "ResouceVideo{"
        + ", id="
        + id
        + ", title="
        + title
        + ", url="
        + url
        + ", orderSort="
        + orderSort
        + ", contentId="
        + contentId
        + "}";
  }
}
