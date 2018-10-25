package com.lssg.hikvision.service;

import java.util.*;

import com.lssg.common.util.HttpClientUtils;
import com.lssg.hikvision.model.AccessTokenResponse;
import com.lssg.hikvision.model.OpenLiveResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 开启直播功能
 * 
 * @author fanrui 2018年6月27日
 */
public class OpenLiveService {
	@Autowired
	private  static  RedisTemplate redisTemplate;

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(OpenLiveService.class);
	@SuppressWarnings({ "static-access", "rawtypes" })
	public static List<OpenLiveResponse> openLiveFunction(Map<String, Object> map) throws Exception {
		AccessTokenResponse at = QueryAccessTokenService.getAccessTokenResult(map);
		String accessToken = at.getAccessToken();
		map.put("accessToken", accessToken);
		map.put("source", "C27548604:1");
		String result = HttpClientUtils.send("https://open.ys7.com/api/lapp/live/video/open", map, "utf-8");
		log.info("查询直播开通功能:"+result);
		// json转bean
		JSONObject object = JSONObject.fromObject(result);
		String str = object.getString("data");
		JSONArray ja = JSONArray.fromObject(str);
		System.out.println(ja);
		Collection collection = JSONArray.toCollection(ja, OpenLiveResponse.class);
		List<OpenLiveResponse> list = new ArrayList<OpenLiveResponse>();
		Iterator it = collection.iterator();
		while (it.hasNext()) {
			OpenLiveResponse o = (OpenLiveResponse) it.next();
			list.add(o);
		}

		return list;
	}


	public static void main(String[] args) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String accessToken =  redisTemplate.opsForValue().get("accessToken")+"";
		map.put("accessToken", accessToken);
		map.put("source", "C27548604:1");
		List<OpenLiveResponse> result =openLiveFunction(map);
	}

}
