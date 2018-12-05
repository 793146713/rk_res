package cn.zhy.resouese;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.zhy.resouese.mapper")
public class RkResApplication {

    public static void main(String[] args) {
        SpringApplication.run(RkResApplication.class, args);
    }
}
