package cn.zhy.resouese.entity;

import lombok.Data;

import java.util.Date;

/** @author: ZzzHhYyy @Date: 2019/3/6 22:22 */
@Data
public class IpEntity {

    Date time = new Date();
    String ip;
    String area;
    String type;
    String country;
    String province;
    String city;
    String town;
}
