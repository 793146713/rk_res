package cn.zhy.resouese.service.impl;

import cn.zhy.resouese.entity.SysUser;
import cn.zhy.resouese.entity.UserLog;
import cn.zhy.resouese.mapper.SysUserMapper;
import cn.zhy.resouese.mapper.UserLogMapper;
import cn.zhy.resouese.sercice.SysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 服务实现类
 *
 * @author admin
 * @since 2018-11-09
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService {
  @Autowired private UserLogMapper userLogMapper;

  @Override
  public void upDateUserLogin(SysUser sysUser, Long uid, UserLog userLog) throws Exception {
    sysUser.setLastLoginTime(new Date());
    baseMapper.updateById(sysUser);
    userLogMapper.insert(userLog);
  }
}
