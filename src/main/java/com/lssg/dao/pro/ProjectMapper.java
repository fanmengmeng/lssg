package com.lssg.dao.pro;


import com.lssg.model.pro.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMapper {
   /**
    *获取总条数
    * @return
    */
   int infoTotal();

   /**
    *获取所有的字段
    * @return
    */
   List<Project> getProjectAndDevice();

   public List<Project> getProject();
}
