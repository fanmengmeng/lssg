package com.lssg.dao.pro;

import com.lssg.model.pro.Device;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceMapper {
    /*分类查询工地所属摄像头*/
    public List<Device> selectDeviceSort(List<String> projectNames);
}
