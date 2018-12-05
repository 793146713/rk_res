package cn.zhy.resouese;

import cn.zhy.resouese.entity.AdConfig;
import cn.zhy.resouese.mapper.AdConfigMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class RkResApplicationTests {

  @Test
  public void contextLoads() {}

  @Autowired private AdConfigMapper adConfigMapper;

  @Test
  public void testSelect() {
    System.out.println(("----- selectAll method test ------"));
    List<AdConfig> adConfigs = adConfigMapper.selectList(null);
    Assert.assertEquals(5, adConfigs.size());
    adConfigs.forEach(System.out::println);
  }
}
