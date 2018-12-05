package cn.zhy.resouese.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2018-11-09
 */
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
    //资源分类
    @TableField(exist = false)
    private ResouceCatalog resouceCatalog;
    //视频
    @TableField(exist = false)
    private List<ResouceVideo> resouceVideo;
    //文件
    @TableField(exist = false)
    private  ResouceDownloadFile resouceDownloadFile;

    public ResouceDownloadFile getResouceDownloadFile() {
        return resouceDownloadFile;
    }

    public void setResouceDownloadFile(ResouceDownloadFile resouceDownloadFile) {
        this.resouceDownloadFile = resouceDownloadFile;
    }

    public List<ResouceVideo> getResouceVideo() {
        return resouceVideo;
    }

    public void setResouceVideo(List<ResouceVideo> resouceVideo) {
        this.resouceVideo = resouceVideo;
    }

    public ResouceCatalog getResouceCatalog() {
        return resouceCatalog;
    }

    public void setResouceCatalog(ResouceCatalog resouceCatalog) {
        this.resouceCatalog = resouceCatalog;
    }

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getSeoKeyword() {
        return seoKeyword;
    }

    public void setSeoKeyword(String seoKeyword) {
        this.seoKeyword = seoKeyword;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public String getThumbnailImg() {
        return thumbnailImg;
    }

    public void setThumbnailImg(String thumbnailImg) {
        this.thumbnailImg = thumbnailImg;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getIsHome() {
        return isHome;
    }

    public void setIsHome(Integer isHome) {
        this.isHome = isHome;
    }

    public Integer getIsNews() {
        return isNews;
    }

    public void setIsNews(Integer isNews) {
        this.isNews = isNews;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public Integer getSiteType() {
        return siteType;
    }

    public void setSiteType(Integer siteType) {
        this.siteType = siteType;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassPid() {
        return classPid;
    }

    public void setClassPid(String classPid) {
        this.classPid = classPid;
    }

    @Override
    public String toString() {
        return "ResouceContent{" +
        ", id=" + id +
        ", title=" + title +
        ", summary=" + summary +
        ", addTime=" + addTime +
        ", seoKeyword=" + seoKeyword +
        ", seoDescription=" + seoDescription +
        ", thumbnailImg=" + thumbnailImg +
        ", clickCount=" + clickCount +
        ", author=" + author +
        ", isShow=" + isShow +
        ", isHome=" + isHome +
        ", isNews=" + isNews +
        ", catalogId=" + catalogId +
        ", siteType=" + siteType +
        ", isRecommend=" + isRecommend +
        ", description=" + description +
        ", classPid=" + classPid +
        "}";
    }
}
