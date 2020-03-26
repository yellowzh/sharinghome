package com.lnsf.vo;

import lombok.Data;

import java.util.List;

@Data
public class SeeVo {
    private String name;
    private String type= "line";
    private String stack= "总量";
    List<Integer>  data;
}
