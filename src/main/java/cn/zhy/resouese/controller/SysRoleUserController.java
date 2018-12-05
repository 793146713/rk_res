package cn.zhy.resouese.controller;


import cn.zhy.resouese.entity.ResouceContent;
import cn.zhy.resouese.sercice.MessageService;
import cn.zhy.resouese.sercice.ResouceCatalogService;
import cn.zhy.resouese.sercice.ResouceContentService;
import cn.zhy.resouese.sercice.SiteConfigService;
import cn.zhy.resouese.utils.ComputerMonitorUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2018-11-09
 */
@Controller
@RequestMapping("/sysRoleUser")
public class SysRoleUserController {
    @Autowired private ResouceContentService resouceContentService;
    @Autowired private ResouceCatalogService resouceCatalogService;
    @Autowired private MessageService messageService;
    @Autowired private SiteConfigService siteConfigService;
    @GetMapping("/index")
    @ResponseBody
    public Object getIndex() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        // 统计资源分类数据
        HashMap<String, Object> reslog = new HashMap<>();
        //表示文章，2表示视频，3表示软件
        Integer wenzhang = resouceContentService.selectCount(new EntityWrapper<ResouceContent>().eq("site_type",1));;
        reslog.put("wenzhang", wenzhang);
        Integer shiping = resouceContentService.selectCount(new EntityWrapper<ResouceContent>().eq("site_type",2));;
        reslog.put("shiping", shiping);
        Integer ruanjian =resouceContentService.selectCount(new EntityWrapper<ResouceContent>().eq("site_type",3));;
        reslog.put("ruanjian", ruanjian);
        int liuyan = messageService.selectCount(null);
        reslog.put("liuyan", liuyan);
        map.put("reslog", reslog);
        //获取服务器使用运行情况
        double cpuUsage = ComputerMonitorUtil.getCpuUsage();
        double diskUsage = ComputerMonitorUtil.getDiskUsage();
        double memUsage = ComputerMonitorUtil.getMemUsage();
        map.put("cpuUsage", cpuUsage);
        map.put("diskUsage", diskUsage);
        map.put("memUsage", memUsage);
        return map;
    }

    @GetMapping("/getabout")
    @ResponseBody
    public  Object getAout(){
        return siteConfigService.selectList(null).get(0);
    }
}

