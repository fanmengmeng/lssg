package com.lssg.hikvision.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import com.lssg.common.constant.HkTokenConstant;
import com.lssg.common.util.BeanUtils;
import com.lssg.common.util.HttpClientUtils;
import com.lssg.hikvision.model.AccessTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 根据appKey和secret获取accessToken
 *
 * @author fanrui 2018年6月27日
 */
public class QueryAccessTokenService {
    private static final Logger logger = LoggerFactory.getLogger(QueryAccessTokenService.class);

    public static AccessTokenResponse getAccessTokenResult(Map<String, Object> map) throws Exception {
        map.put("appKey", HkTokenConstant.APPKEY);
        map.put("appSecret", HkTokenConstant.APPSECRET);
        String result = HttpClientUtils.send("https://open.ys7.com/api/lapp/token/get", map, "utf-8");
        logger.info("查询accesstoken:" + result);

        return BeanUtils.readValue(result, AccessTokenResponse.class);
    }

	public static void main(String[] args) throws IOException, ParseException {
		Map<String,Object> map = new HashMap<>();
		map.put("appKey", HkTokenConstant.APPKEY);
		map.put("appSecret",HkTokenConstant.APPSECRET);
		String result = HttpClientUtils.send("https://open.ys7.com/api/lapp/token/get", map, "utf-8");
		System.out.println(result);
	}

}
