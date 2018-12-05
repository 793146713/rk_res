package cn.zhy.resouese.test;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/** @author: ZzzHhYyy @Date: 2018/11/9 9:24 */
// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {
  public static void main(String[] args) {
    GlobalConfig config = new GlobalConfig();
    String dbUrl = "jdbc:mysql://localhost:3306/rk_resouces?useSSL=false";
    DataSourceConfig dataSourceConfig = new DataSourceConfig();
    dataSourceConfig
        .setDbType(DbType.MYSQL)
        .setUrl(dbUrl)
        .setUsername("root")
        .setPassword("1234")
        .setDriverName("com.mysql.jdbc.Driver");
    StrategyConfig strategyConfig = new StrategyConfig();
    strategyConfig
        .setCapitalMode(true)
        .setEntityLombokModel(false)
        .setDbColumnUnderline(true)
        .setNaming(NamingStrategy.underline_to_camel);
    config
        .setActiveRecord(false)
        .setEnableCache(false)
        .setAuthor("admin")
        // 这里就直接输出到项目里面，不用再复制进来
        .setOutputDir("D:\\Users\\maybe\\rk_res\\src\\main\\java\\")
        .setFileOverride(true)
        .setServiceName("%sService");
    new AutoGenerator()
        .setGlobalConfig(config)
        .setDataSource(dataSourceConfig)
        .setStrategy(strategyConfig)
        .setPackageInfo(
            new PackageConfig()
                .setParent("cn.zhy.resouese")
                .setController("controller")
                .setEntity("entity")
                .setService("sercice")
                .setMapper("mapper"))
        .execute();
  }
}
