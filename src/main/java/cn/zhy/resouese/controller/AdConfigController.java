package cn.zhy.resouese.controller;

import cn.zhy.resouese.sercice.AdConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端控制器
 *
 * @author admin
 * @since 2018-11-09
 */
@RestController
@RequestMapping("/adConfig")
public class AdConfigController {
  @Autowired AdConfigService adConfigService;

  @RequestMapping("/index")
  public Object index() {
    return adConfigService.selectList(null);
  }
}
