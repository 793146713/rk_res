package cn.zhy.resouese.controller;

import cn.zhy.resouese.entity.SysUser;
import cn.zhy.resouese.sercice.SysUserService;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 前端控制器
 *
 * @author admin
 * @since 2018-11-09
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController {
  @Autowired SysUserService sysUserService;

  @RequestMapping("/admin/user/indexlist.html")
  public Object indexlist(
      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
      Model model) {
    Page<SysUser> page = new Page<>(pageNum, pageSize);
    Page<SysUser> selectPage = sysUserService.selectPage(page);
    model.addAttribute("pages", selectPage);
    return "admin/user/indexlist";
  }

  @RequestMapping("/admin/user/add.html")
  public Object add(Integer id, Model model) {
    if (null != id) {
      model.addAttribute("user", sysUserService.selectById(id));
    }
    return "/admin/user/add.html";
  }
}
