package com.lssg.common.task;

import com.lssg.common.constant.HkTokenConstant;
import com.lssg.hikvision.model.AccessTokenResponse;
import com.lssg.hikvision.service.QueryAccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 启动获取海康accesstoken线程
 *
 * @author       fanrui
 * @version      1.0
 * @date         2018/9/20  17:41
 */

@Service
@Slf4j
@RefreshScope
public class HkTokenThread  implements Runnable{
    private RedisTemplate<String, String> redisTemplate;


    @Autowired
    public HkTokenThread(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Map<String, Object> map = new HashMap<>();
                map.put("appKey", HkTokenConstant.APPKEY);
                map.put("appSecret", HkTokenConstant.APPSECRET);
                AccessTokenResponse accessToken = QueryAccessTokenService.getAccessTokenResult(map);
                if (accessToken != null) {
                    if (accessToken.getAccessToken() != null) {
                        redisTemplate.opsForValue().set("accessToken", accessToken.getAccessToken());
                        log.info("获取的accessToken为"+accessToken.getAccessToken());
                    }
                }
                if (null != accessToken.getAccessToken()) {
                    // 休眠7000秒
                    Thread.sleep((accessToken.getExpireTime() - 3000) * 1000);
                } else {
                    // 如果access_token为null，60秒后再获取
                    Thread.sleep(3600 * 1000);
                }
            } catch (InterruptedException e) {
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e1) {
                    log.error("{}", e1);
                }
                log.error("{}", e);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
