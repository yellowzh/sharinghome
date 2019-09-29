package com.lnsf.service.impl;


import com.lnsf.bean.Homeshow;
import com.lnsf.dao.HomeshowMapper;
import com.lnsf.service.HomeShowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class HomeShowServiceImpl implements HomeShowService {
    @Resource
    private HomeshowMapper homeshowMapper;
    @Override
    public List<Homeshow> getAllHomeShow() {
        return homeshowMapper.selectByExample(null);
    }

    @Override
    public Homeshow getHomeShowById(Integer id) {
        return homeshowMapper.selectByPrimaryKey(id);
    }
}
