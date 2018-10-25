package com.lssg.controller.device;

import com.lssg.common.util.HttpClientUtils;
import com.lssg.hikvision.service.PtzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * 开启云台控制层
 *
 * @author       fanrui
 * @version      1.0
 * @date         2018/10/10  10:04
 */
@Controller
public class PtzController {
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/ptz/open")
    @ResponseBody
    public Object openPtz( String deviceSerial, Integer channelNo, String direction) throws IOException, ParseException {
        String accessToken =  redisTemplate.opsForValue().get("accessToken")+"";
        String url = "https://open.ys7.com/api/lapp/device/ptz/start";
        StringBuffer buffer = new StringBuffer();
        buffer.append("&accessToken="+accessToken);
        buffer.append("&deviceSerial="+"C47135865");
        buffer.append("&channelNo="+1);
        buffer.append("&direction="+5);
        buffer.append("&speed="+1);

        return HttpClientUtils.sendPost(url,buffer.toString());
    }

    @GetMapping("/ptz/get")
    public  String ptz() {
        return "/video/live/ptz";
    }
}
