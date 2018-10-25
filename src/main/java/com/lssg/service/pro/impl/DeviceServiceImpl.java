package com.lssg.service.pro.impl;

import com.lssg.dao.pro.DeviceMapper;
import com.lssg.model.pro.Device;
import com.lssg.service.pro.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public List<Device> selectDeviceSort(List<String> projectNames) {
        return deviceMapper.selectDeviceSort(projectNames);

    }
}
