package cn.zhy.resouese.controller;

import cn.zhy.resouese.entity.*;
import cn.zhy.resouese.sercice.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** @author: ZzzHhYyy @Date: 2018/11/9 11:52 */
@RestController
@RequestMapping("/resous")
public class IndexController {
    // 资源内容表
    @Autowired ResouceContentService resouceContentService;
    // 资源分类
    @Autowired ResouceCatalogService resouceCatalogService;
    // 资源标签
    @Autowired ResouceLableService resouceLableService;
    // 广告
    @Autowired AdConfigService adConfigService;
    // 推荐视频
    @Autowired ResouceVideoService resouceVideoService;
    // 友情链接
    @Autowired LinkConfigService linkConfigService;
    // 资源标签关联中间表
    @Autowired ResouceLableContentService resouceLableContentService;
    /**
     * 推荐内容
     *
     * @return
     */
    @GetMapping("/tuijian")
    public Object index(
            @RequestParam(name = "pageIndex", defaultValue = "1") Integer pageIndex,
            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        Page<ResouceContent> page = new Page<>(pageIndex, pageSize);
        Page<ResouceContent> pageInfo =
                resouceContentService.selectPage(
                        page, new EntityWrapper<ResouceContent>().eq("is_show", 1));
        for (ResouceContent resouceContent : pageInfo.getRecords()) {
            resouceContent.setResouceCatalog(
                    resouceCatalogService.selectById(resouceContent.getCatalogId()));
        }
        map.put("data", pageInfo);
        map.put("code", "200");
        map.put("pages", page.getPages());
        return map;
    }

    @GetMapping("/biaoqian")
    public Object biaoqian() {
        return resouceLableService.selectList(new EntityWrapper<ResouceLable>().eq("is_news", "1"));
    }

    /**
     * 获取首页标签
     *
     * @param id 资源类型
     * @return
     */
    @GetMapping("/getAllbiaoqian/{id}")
    public Object getAllbiaoqian(@PathVariable(value = "id", required = true) Integer id) {
        return resouceLableService.selectList(
                new EntityWrapper<ResouceLable>().eq("site_type", id));
    }

    @RequestMapping("/guanggao")
    public Object guanggao() {
        return adConfigService.selectList(new EntityWrapper<AdConfig>().eq("is_show", "1"));
    }

    @GetMapping("/paihang/{id}")
    public Object paihang(@PathVariable(value = "id", required = true) Integer id) {
        EntityWrapper<ResouceContent> wrapper = new EntityWrapper<>();
        if (id == 2) {
            wrapper.eq("is_recommend", 1);
        } else if (id == 3) {
            wrapper.orderBy("add_time");
        } else {
            // 升序
            wrapper.orderBy("click_count", false);
        }
        return resouceContentService
                .selectPage(new Page<ResouceContent>(0, 5), wrapper)
                .getRecords();
    }

    @GetMapping("/tuijianvideo")
    public Object paihang() {
        Wrapper<ResouceContent> wrapper =
                new EntityWrapper<ResouceContent>()
                        .eq("site_type", "2")
                        .eq("is_recommend", "1")
                        .eq("is_show", "1");
        List<ResouceContent> resouceContents = resouceContentService.selectList(wrapper);
        for (ResouceContent re : resouceContents) {
            re.setResouceVideo(
                    resouceVideoService.selectList(
                            new EntityWrapper<ResouceVideo>().eq("content_id", re.getId())));
        }
        return resouceContents;
    }

    @GetMapping("/youqing")
    public Object youqing() {
        return linkConfigService.selectList(new EntityWrapper<LinkConfig>().eq("is_show", "1"));
    }

    @GetMapping("/articleDetail/{id}")
    public Object articleDetail(@PathVariable(value = "id", required = true) Integer id) {
        ResouceContent resouceContent = resouceContentService.selectById(id);
        resouceContent.setResouceCatalog(
                resouceCatalogService.selectById(resouceContent.getCatalogId()));
        resouceContent.setClickCount(resouceContent.getClickCount() + 1);
        resouceContentService.updateById(resouceContent);
        return resouceContent;
    }

    /**
     * 标签查询
     *
     * @param id
     * @return
     */
    @GetMapping("/getResousByBiaoqian/{id}")
    public Object getResousByBiaoqian(@PathVariable(name = "id", required = true) Integer id) {
        List<ResouceLableContent> lable_id =
                resouceLableContentService.selectList(
                        new EntityWrapper<ResouceLableContent>().eq("lable_id", id));
        ArrayList<Long> list = new ArrayList<>();
        for (ResouceLableContent re : lable_id) {
            list.add(re.getContentId());
        }
        if (list.size() >= 1) {
            List<ResouceContent> contentList =
                    resouceContentService.selectList(
                            new EntityWrapper<ResouceContent>().in("id", list));
            for (ResouceContent resouceContent : contentList) {
                // 设置标签
                resouceContent.setResouceCatalog(
                        resouceCatalogService.selectById(resouceContent.getCatalogId()));
            }
            return contentList;
        }
        return null;
    }

    /**
     * articleList查询文章
     *
     * @param fenleiid
     * @param paixuid
     * @return
     */
    @GetMapping("/tiaojianChaxun")
    public List<ResouceContent> tiaojianChaxun(
            @RequestParam(name = "type", required = true) Integer type,
            @RequestParam(name = "fenleiid", required = true) Integer fenleiid,
            @RequestParam(name = "paixuid", required = true) Integer paixuid) {
        Wrapper<ResouceLableContent> wrappers = new EntityWrapper<ResouceLableContent>();
        if (fenleiid > 0) {
            wrappers.eq("lable_id", fenleiid);
        }
        List<ResouceLableContent> resouceLables = resouceLableContentService.selectList(wrappers);
        ArrayList<Long> list = new ArrayList<>();
        for (ResouceLableContent re : resouceLables) {
            list.add(re.getContentId());
        }
        if (list.size() >= 1) {
            Wrapper<ResouceContent> wrapper =
                    new EntityWrapper<ResouceContent>().in("id", list).eq("site_type", type);
            if (paixuid == 1) {
                wrapper.orderBy("click_count", false);
            } else if (paixuid == 2) {
                wrapper.orderBy("add_time", false);
            }
            return resouceContentService.selectList(wrapper);
        }
        return null;
    }
}
