package com.lssg.service.pro.impl;

import com.github.pagehelper.PageHelper;
import com.lssg.dao.pro.ProjectMapper;
import com.lssg.model.pro.Project;
import com.lssg.service.pro.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper infoMapper;

    /**
     * 分页查询项目信息
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> selectByPage(int pageNumber, int pageSize) {
        Map<String, Object> result = new HashMap<>();
        int total = infoMapper.infoTotal();
        // 分页查询
        PageHelper.startPage(pageNumber, pageSize);
        List<Project> rows = infoMapper.getProject();
        result.put("total", total);
        result.put("rows", rows);
        return result;
    }
    @Override
    public List<Project> getProjectAndDevice(){

        return  infoMapper.getProjectAndDevice();
    }

    @Override
    public List<Project> selectInfoName() {

        return infoMapper.getProject();
    }
}
