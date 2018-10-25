package com.lssg.hikvision.service;

import com.lssg.common.util.HttpClientUtils;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

public class LiveService {
    public static String openLive(Map<String, Object> map) throws IOException, ParseException {
        String result = HttpClientUtils.send("https://open.ys7.com/api/lapp/live/address/get", map, "utf-8");
        System.out.println("查询直播地址:" + result);
        // json转bean
        JSONObject object = JSONObject.fromObject(result);
        String str = object.getString("data");
        return str;
    }
}
