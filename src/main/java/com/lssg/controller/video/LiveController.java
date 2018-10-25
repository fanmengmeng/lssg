package com.lssg.controller.video;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import com.lssg.model.pro.Project;
import com.lssg.service.pro.DeviceService;
import com.lssg.service.pro.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 监控直播视频控制层
 * 
 * @author fanrui 2018年7月4日
 */
@Controller
public class LiveController {
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private ProjectService infoService;
	@Autowired
	private  RedisTemplate redisTemplate;

	@RequestMapping(value = "/live")
    public String openlive(Map<String, Object> map,HttpServletRequest request) throws Exception {
    	List<Project> infoList = infoService.selectInfoName();
		// List<LiveAddressResponse> la = QueryLiveAddressService.getLiveAddress(map);
		return "/video/live/live";
    }
	
	
/*
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/pass")
	@ResponseBody
	public String getliveAddress(Map<String, Object> map,HttpServletRequest request)
			throws Exception {
		//String areaName =new String(request.getParameter("areaName").getBytes("ISO-8859-1"),"utf-8");
		String infoName =request.getParameter("selectName");
		System.out.println(infoName);
		*/
/*if ("实验小学".equals(areaName) || areaName == null) {
			areaName = "实验小学";
			
		} *//*

		List<Device> deviceList = deviceService.selectDeviceSort(infoName);
		System.out.println(deviceList);
		String[] deviceSerials = new String[deviceList.size()];
		int[] channelNos = new int[deviceList.size()];
		for (int i = 0; i < deviceList.size(); i++) {
			Device device = deviceList.get(i);
			deviceSerials[i] = device.getDeviceserial();
			channelNos[i] = device.getChannelno();

		}
		*/
/* map 转string 键值对 *//*

		System.out.println(deviceSerials);
		String channelNo = Arrays.toString(channelNos);
		channelNo = channelNo.substring(1, channelNo.length() - 1);
		String[] cno = channelNo.split(","); // 用,分割
		System.out.println(cno);

		Map<String, String> para = new HashMap<String, String>();// 定义一个map集合
		for (int i = 0; i < deviceSerials.length; i++) {
			para.put(deviceSerials[i], cno[i]);// map集合添加数据
		}
		// "\""+ + "\""
		System.out.println(para);
		String source = StringUtils.transMapToString(para);
		// String deviceSerial = sb.toString();
		System.out.println(source);
		// String deviceSerial = StringUtils.join(deviceSerials, ",");

		String accessToken =  redisTemplate.opsForValue().get("accessToken")+"";
		map.put("accessToken", accessToken);
		map.put("source", source);
		System.out.println(map);
		return  LiveService.openLive(map);
		//mav.addObject("la", list);
	*/
/*
	   RedirectAttributes attributes	redirectAttributes.addAttributie("param1",value1);
       return:"redirect：/path/list" 	*//*

	}
*/

}
