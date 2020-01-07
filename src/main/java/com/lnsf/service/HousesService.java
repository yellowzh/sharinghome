package com.lnsf.service;

import com.lnsf.bean.Houses;

import java.util.List;

public interface HousesService {
    List<Houses> getAllHomeShow();
    Houses getHomeShowById(Integer id);
}
