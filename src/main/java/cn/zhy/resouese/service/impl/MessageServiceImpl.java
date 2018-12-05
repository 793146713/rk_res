package cn.zhy.resouese.service.impl;

import cn.zhy.resouese.entity.Message;
import cn.zhy.resouese.mapper.MessageMapper;
import cn.zhy.resouese.sercice.MessageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2018-11-09
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
