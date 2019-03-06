package cn.zhy.resouese.utils;

import cn.zhy.resouese.entity.IpEntity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressUtils {

    public static final String APPKEY = "d551873b8d0fea5f"; // 你的appkey
    public static final String URL = "http://api.jisuapi.com/ip/location";

    public static JSONObject getIp(String ip) {
        String result = null;
        String url = URL + "?appkey=" + APPKEY + "&ip=" + ip;
        JSONObject resultarr = null;
        try {
            result = HttpUtil.sendGet(url, "utf-8");
            JSONObject json = JSONObject.parseObject(result);
            if (json.getIntValue("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
                resultarr = json.getJSONObject("result");
                String area = resultarr.getString("area");
                String type = resultarr.getString("type");
                System.out.println(area + " " + type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultarr;
    }
    // 测试
    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        String ips = addr.getHostAddress().toString(); // 获取本机ip
        JSONObject ip = getIp(ips);
        IpEntity ipEntity = JSON.toJavaObject(ip, IpEntity.class);
        System.out.println(ipEntity.toString());
    }
}
