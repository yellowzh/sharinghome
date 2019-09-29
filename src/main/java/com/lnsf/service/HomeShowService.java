package com.lnsf.service;

import com.lnsf.bean.Homeshow;

import java.util.List;

public interface HomeShowService {
    List<Homeshow> getAllHomeShow();
    Homeshow getHomeShowById(Integer id);
}
