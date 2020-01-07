package com.lnsf.service.impl;


import com.lnsf.bean.Houses;
import com.lnsf.dao.HousesMapper;
import com.lnsf.service.HousesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class HousesServiceImpl implements HousesService {
    @Resource
    private HousesMapper housesMapper;
    @Override
    public List<Houses> getAllHomeShow() {
        return housesMapper.selectByExample(null);
    }

    @Override
    public Houses getHomeShowById(Integer id) {
        return housesMapper.selectByPrimaryKey(id);
    }
}
