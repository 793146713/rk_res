package cn.zhy.resouese.controller;

import cn.zhy.resouese.entity.ResouceContent;
import cn.zhy.resouese.entity.ResouceVideo;
import cn.zhy.resouese.sercice.ResouceContentService;
import cn.zhy.resouese.sercice.ResouceVideoService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** @author: ZzzHhYyy @Date: 2018/11/11 11:05 */
@RestController
@RequestMapping("/video")
public class VideoController {
  @Autowired ResouceVideoService resouceVideoService;
  @Autowired ResouceContentService resouceContentService;

  @GetMapping("/getVideoByid/{id}")
  public Object getVideoByid(@PathVariable(value = "id", required = true) Integer id) {
    ResouceContent resouceContent = resouceContentService.selectById(id);
    if (resouceContent.getSiteType() != 2) {
      return "请求无效";
    } else {
      resouceContent.setResouceVideo(
          resouceVideoService.selectList(
              new EntityWrapper<ResouceVideo>().eq("content_id", resouceContent.getId())));
    }
    return resouceContent;
  }

  @GetMapping("/getOneVideo")
  public Object getOneVideo(
      @RequestParam(name = "active", required = true) Integer active,
      @RequestParam(name = "id", required = true) Integer id) {
    ResouceContent resouceContent = resouceContentService.selectById(id);
    if (resouceContent.getSiteType() != 2) {
      return "请求无效";
    } else {
        Wrapper<ResouceVideo> wrapper = new EntityWrapper<ResouceVideo>()
                .eq("content_id", resouceContent.getId())
                .eq("order_sort", active);
        return resouceVideoService.selectOne(wrapper);
    }
  }
}
