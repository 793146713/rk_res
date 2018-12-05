package cn.zhy.resouese.sercice;

import cn.zhy.resouese.entity.SysUser;
import cn.zhy.resouese.entity.UserLog;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2018-11-09
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 更新最后时间
     * @param sysUser
     * @param uid
     * @throws Exception
     */
    void upDateUserLogin(SysUser sysUser, Long uid, UserLog userLog) throws  Exception;
}
