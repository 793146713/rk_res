package cn.zhy.resouese.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZzzHhYyy
 * @Date: 2018/11/9 13:47
 */
public class JsonUtils {
    //状态码   100-成功    200-失败
    private int code;
    private boolean success;
    private int status;
    //提示信息
    private String msg;

    //用户要返回给浏览器的数据
    private Map<String, Object> extend = new HashMap<String, Object>();

    public static JsonUtils success(){
        JsonUtils result = new JsonUtils();
        result.setCode(100);
        result.setStatus(200);
        result.setSuccess(true);
        result.setMsg("处理成功！");
        return result;
    }

    public static JsonUtils fail(){
        JsonUtils result = new JsonUtils();
        result.setCode(200);
        result.setStatus(100);
        result.setSuccess(false);

        result.setMsg("处理失败！");
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public JsonUtils add(String key, Object value){
        this.getExtend().put(key, value);
        return this;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
