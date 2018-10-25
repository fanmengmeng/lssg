package com.lssg.controller.video;

import com.lssg.model.pro.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 录像回放
 *
 * @author fanrui
 * @version 1.0
 * @date 2018/10/18 21:45
 */
@Controller
public class PlayBackController {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/playback")
    public String playback() {
        return "/video/playback/playback";
    }

    @PostMapping("/accesstoken/get")
    @ResponseBody
    public String getAccessToekn() {
        String accessToken = redisTemplate.opsForValue().get("accessToken") + "";
        return accessToken;
    }


}
