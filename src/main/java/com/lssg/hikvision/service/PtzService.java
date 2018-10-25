package com.lssg.hikvision.service;

import com.lssg.common.util.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * 开启云台控制
 *
 * @author fanrui
 * @version 1.0
 * @date 2018/10/10  9:32
 */

public class PtzService {

    public static Object openPtz(String url,String param) throws IOException, ParseException {
        return HttpClientUtils.sendPost("https://open.ys7.com/api/lapp/device/ptz/start", param);

    }

    public static void main(String[] args) throws IOException, ParseException {
        int channelNo = 1;
        Map<String, Object> map = new HashMap<>();
        map.put("accessToken", "at.33gqxpuc7mi9tf2p9sfxb6dv23l4vt3u-5byjxjdkbf-0b1y39h-6pad5m4s0");
        map.put("deviceSerial", "C47135865");
        map.put("channelNo", channelNo);
        map.put("direction", 0);
        map.put("speed", 1);
        Object object =  HttpClientUtils.send("https://open.ys7.com/api/lapp/device/ptz/start", map, "utf-8");
         System.out.println(object);
    }
}


