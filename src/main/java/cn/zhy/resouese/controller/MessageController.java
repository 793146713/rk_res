package cn.zhy.resouese.controller;

import cn.zhy.resouese.entity.Message;
import cn.zhy.resouese.sercice.MessageService;
import cn.zhy.resouese.utils.AddressUtils;
import cn.zhy.resouese.utils.FileUploadUtils;
import cn.zhy.resouese.utils.JsonUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 前端控制器
 *
 * @author admin
 * @since 2018-11-09
 */
@RestController
@RequestMapping("/message")
public class MessageController {
  @Autowired private MessageService messageService;

  @PutMapping("/InsertMessage")
  public Object InsertMessage(
      @RequestParam(name = "message", required = true) String content, HttpServletRequest request) {
    try {
      String ip = request.getLocalAddr();
      String addresses = AddressUtils.getAddresses("ip=" + ip, "utf-8");
      JSONObject parseObject = (JSONObject) JSONObject.parseObject(addresses).get("data");

      Message msg = new Message();
      msg.setAddTime(new Date());
      msg.setIp(ip);
      msg.setContent(content);
      String sb =
          String.valueOf(parseObject.get("country"))
              + parseObject.get("region")
              + parseObject.get("city")
              + parseObject.get("county")
              + parseObject.get("isp");
      msg.setAddress(sb);

      messageService.insert(msg);
      return JsonUtils.success();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return JsonUtils.fail();
  }

  @PostMapping("/doUploadPic")
  public Object doUploadPic(@RequestParam("file") MultipartFile file, HttpServletRequest request)
      throws UnsupportedEncodingException {
    if (file.isEmpty()) {
      return JsonUtils.fail();
    }
    String basePath = (String) request.getAttribute("basePath");
    String filename = FileUploadUtils.extractFilename(file, basePath, true);
    String upload = FileUploadUtils.upload(request, file, null);

    System.out.println(filename + "aaa" + upload);
    Map<String, Object> map = new HashMap<String, Object>();
    Map<String, Object> map2 = new HashMap<String, Object>();
    map.put("code", 0); // 0表示成功，1失败
    map.put("msg", "上传成功"); // 提示消息
    map.put("data", map2);
    map2.put("src", upload); // 图片url
    map2.put("title", "上传的图片"); // 图片名称，这个会显示在输入框里
    return new JSONObject(map).toString();
  }
}
