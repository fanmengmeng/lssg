package com.lssg.service.pro;

import com.lssg.model.pro.Project;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    public Map<String, Object> selectByPage(int pageNumber, int pageSize);

    public List<Project> selectInfoName() ;

    public List<Project> getProjectAndDevice();
}
