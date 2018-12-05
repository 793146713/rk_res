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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
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

    public String getSiteQuotation() {
        return siteQuotation;
    }

    public void setSiteQuotation(String siteQuotation) {
        this.siteQuotation = siteQuotation;
    }

    public String getAboutSummary() {
        return aboutSummary;
    }

    public void setAboutSummary(String aboutSummary) {
        this.aboutSummary = aboutSummary;
    }

    public String getAboutDashang() {
        return aboutDashang;
    }

    public void setAboutDashang(String aboutDashang) {
        this.aboutDashang = aboutDashang;
    }

    public String getAboutErweima() {
        return aboutErweima;
    }

    public void setAboutErweima(String aboutErweima) {
        this.aboutErweima = aboutErweima;
    }

    @Override
    public String toString() {
        return "SiteConfig{" +
        ", id=" + id +
        ", siteName=" + siteName +
        ", seoKeyword=" + seoKeyword +
        ", seoDescription=" + seoDescription +
        ", siteQuotation=" + siteQuotation +
        ", aboutSummary=" + aboutSummary +
        ", aboutDashang=" + aboutDashang +
        ", aboutErweima=" + aboutErweima +
        "}";
    }
}
