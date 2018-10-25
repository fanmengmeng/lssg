package com.lssg.hikvision.service;

import com.lssg.common.util.HttpClientUtils;

import java.io.IOException;
import java.text.ParseException;

/**
 * 设备抓拍图片
 */
public class CaptureService {
    public static Object openPtz(String url,String param) throws IOException, ParseException {
        return HttpClientUtils.sendPost("https://open.ys7.com/api/lapp/device/capture", param);

    }

    public static void main(String[] args){
        StringBuffer buffer = new StringBuffer();
        buffer.append("&accessToken="+"at.63zg4qhgd9qgf2j52a4ovnrn8ehou49m-1vw8ibfvaf-043mbg2-w89naeeqq");
        buffer.append("&deviceSerial="+"C47135865");
        buffer.append("&deviceSerial="+1);
        HttpClientUtils.sendPost("https://open.ys7.com/api/lapp/device/capture",buffer.toString());
    }
}
