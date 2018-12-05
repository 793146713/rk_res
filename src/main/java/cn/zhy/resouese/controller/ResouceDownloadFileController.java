package cn.zhy.resouese.controller;

import cn.zhy.resouese.entity.ResouceContent;
import cn.zhy.resouese.entity.ResouceDownloadFile;
import cn.zhy.resouese.sercice.ResouceContentService;
import cn.zhy.resouese.sercice.ResouceDownloadFileService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 前端控制器
 *
 * @author admin
 * @since 2018-11-09
 */
@Controller
@RequestMapping("/resouceDownloadFile")
public class ResouceDownloadFileController {
  @Autowired private ResouceContentService resouceContentService;
  @Autowired private ResouceDownloadFileService resouceDownloadFileService;
  //  @Autowired private
  @ResponseBody
  @GetMapping("/getResouceById/{id}")
  public Object getResouceById(@PathVariable(value = "id") Integer id) {
    ResouceContent content = resouceContentService.selectById(id);
    content.setResouceDownloadFile(
        resouceDownloadFileService.selectOne(
            new EntityWrapper<ResouceDownloadFile>().eq("content_id", content.getId())));
    return content;
  }
}
