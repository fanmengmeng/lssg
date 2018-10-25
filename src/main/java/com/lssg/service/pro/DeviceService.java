package com.lssg.service.pro;

import com.lssg.model.pro.Device;

import java.util.List;

public interface DeviceService {

    public List<Device> selectDeviceSort(List<String> projectNames);

}
