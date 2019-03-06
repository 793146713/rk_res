package cn.zhy.resouese.controller;

import cn.zhy.resouese.entity.*;
import cn.zhy.resouese.sercice.SysRoleService;
import cn.zhy.resouese.sercice.SysRoleUserService;
import cn.zhy.resouese.sercice.SysUserService;
import cn.zhy.resouese.utils.AddressUtils;
import cn.zhy.resouese.utils.JsonUtils;
import cn.zhy.resouese.utils.Md5Utils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 前端控
 *
 * @author admin
 * @since 2018-11-09
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired private SysUserService sysUserService;
    @Autowired private SysRoleUserService sysRoleUserService;
    @Autowired private SysRoleService sysRoleService;

    @PostMapping("/")
    public Object userLogin(SysUser sysUser, HttpSession session, HttpServletRequest request)
            throws Exception {
        System.out.println(sysUser);
        if (sysUser == null) {
            return JsonUtils.fail();
        }
        EntityWrapper<SysUser> wrapper = new EntityWrapper<SysUser>();
        wrapper.eq("username", sysUser.getUsername());
        wrapper.eq("password", Md5Utils.getMD5String(sysUser.getPassword()));
        wrapper.eq("status", 1);
        SysUser sysUser1 = sysUserService.selectOne(wrapper);
        if (sysUser1 != null) {
            String addr = request.getLocalAddr();
            JSONObject ip = AddressUtils.getIp(addr);
            IpEntity ipEntity = JSON.toJavaObject(ip, IpEntity.class);
            UserLog userLog =
                    new UserLog(
                            sysUser1.getId(),
                            sysUser1.toString(),
                            addr,
                            ipEntity.toString(),
                            new Date());
            sysUserService.upDateUserLogin(sysUser1, sysUser1.getId(), userLog);
            session.setAttribute("loginUser", sysUser1);
        } else {
            return JsonUtils.fail();
        }
        return JsonUtils.success();
    }

    @GetMapping("/{id}")
    public Object getUserByid(@PathVariable(value = "id") Integer id) {
        SysUser sysUser = sysUserService.selectById(id);
        List<SysRoleUser> user_id =
                sysRoleUserService.selectList(
                        new EntityWrapper<SysRoleUser>().eq("user_id", sysUser.getId()));
        ArrayList<Integer> list = new ArrayList<>();
        for (SysRoleUser sysRoles : user_id) {
            list.add(sysRoles.getRoleId());
        }
        List<SysRole> sysRoles =
                sysRoleService.selectList(new EntityWrapper<SysRole>().in("id", list));
        sysUser.setSysRole(sysRoles);
        return sysUser;
    }

    @PostMapping("/checkusername")
    public Object getUserByid(
            @RequestParam(value = "param") String username, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        SysUser sysUser =
                sysUserService.selectOne(new EntityWrapper<SysUser>().eq("username", username));
        if (sysUser != null) {
            map.put("status", "n");
            map.put("info", "账号已经存在！");
        } else {
            map.put("status", "y");
            map.put("info", "账号可以使用！");
        }
        return map;
    }

    @RequestMapping("/add")
    public Object addSysUser(SysUser sysUser, HttpServletRequest request) {
        System.out.println(sysUser.getSysRole());
        try {
            if (sysUser.getId() != null) {
                sysUserService.updateById(sysUser);
            } else {
                sysUser.setAddTime(new Date());
                sysUserService.insert(sysUser);
            }
        } catch (Exception e) {
            return JsonUtils.fail();
        }
        // 添加角色
        for (SysRole sysRole : sysUser.getSysRole()) {
            System.out.println(sysRole.getId());
            sysRole.getId();
            /* SysRoleUser()
            sysRoleUserService.insert()*/
        }
        return JsonUtils.success();
    }
}
