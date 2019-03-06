package cn.zhy.resouese.controller;

import cn.zhy.resouese.entity.ResouceContent;
import cn.zhy.resouese.entity.ResouceVideo;
import cn.zhy.resouese.sercice.ResouceContentService;
import cn.zhy.resouese.sercice.ResouceVideoService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** @author: ZzzHhYyy @Date: 2018/11/11 11:05 */
@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired ResouceVideoService resouceVideoService;
    @Autowired ResouceContentService resouceContentService;

    @GetMapping("/getVideoByid/{id}")
    public Object getVideoByid(@PathVariable(value = "id") Integer id) {
        ResouceContent resouceContent = resouceContentService.selectById(id);
        if (resouceContent.getSiteType() != 2) {
            return "请求无效";
        } else {
            EntityWrapper<ResouceVideo> wrapper = new EntityWrapper<>();
            wrapper.eq("content_id", resouceContent.getId());
            List<ResouceVideo> resouceVideos = resouceVideoService.selectList(wrapper);

            resouceContent.setResouceVideo(resouceVideos);
        }
        return resouceContent;
    }

    @GetMapping("/getVideoByTuJian/{id}")
    public Object getVideoByTuJian(@PathVariable(value = "id") Integer id) {
        ResouceVideo resouceVideo = resouceVideoService.selectById(id);
        ResouceContent resouceContent =
                resouceContentService.selectById(resouceVideo.getContentId());
        if (resouceContent.getSiteType() != 2) {
            return "请求无效";
        } else {
            EntityWrapper<ResouceVideo> wrapper = new EntityWrapper<>();
            wrapper.eq("content_id", resouceContent.getId());
            List<ResouceVideo> resouceVideos = resouceVideoService.selectList(wrapper);

            resouceContent.setResouceVideo(resouceVideos);
        }
        return resouceContent;
    }

    @GetMapping("/getOneVideo")
    public Object getOneVideo(Integer active, Integer id) {
        ResouceContent resouceContent = resouceContentService.selectById(id);
        if (resouceContent.getSiteType() != 2) {
            return "请求无效";
        } else {
            Wrapper<ResouceVideo> wrapper =
                    new EntityWrapper<ResouceVideo>()
                            .eq("content_id", resouceContent.getId())
                            .eq("order_sort", active);
            return resouceVideoService.selectOne(wrapper);
        }
    }
}
