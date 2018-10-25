package com.lssg.controller.device;

import com.lssg.common.util.HttpClientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeviceController{

        @PostMapping("/device/capture")
        @ResponseBody
        public Object openPtz(){
            StringBuffer buffer = new StringBuffer();
            buffer.append("&accessToken="+"at.63zg4qhgd9qgf2j52a4ovnrn8ehou49m-1vw8ibfvaf-043mbg2-w89naeeqq");
            buffer.append("&deviceSerial="+"C31457143");
            buffer.append("&channelNo="+1);
            return   HttpClientUtils.sendPost("https://open.ys7.com/api/lapp/device/capture",buffer.toString());
        }

}
