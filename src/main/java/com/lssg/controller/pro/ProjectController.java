package com.lssg.controller.pro;

import com.lssg.model.pro.Device;
import com.lssg.model.pro.Project;
import com.lssg.service.pro.DeviceService;
import com.lssg.service.pro.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 项目信息控制层
 *
 * @author fanrui
 * @version 1.0
 * @date 2018/9/14 0014 10:23
 */

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private DeviceService deviceService;

    /**
     * 返回项目信息页面
     *
     * @return
     */
    @GetMapping("/project")
    public String info() {
        return "pro/info/projectlist";
    }

    @ResponseBody
    @PostMapping("/project/list")
    public Map<String, Object> selectByPage(Integer pageSize, Integer pageNumber) {

        return projectService.selectByPage(pageNumber, pageSize);
    }

    @ResponseBody
    @GetMapping("/project/get")
    public  List<Project> getProjectAndDevice() {
       return  projectService.getProjectAndDevice();
    }
}
