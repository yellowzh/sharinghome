package com.lnsf.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class SeeListVO {
    List<SeeVo> seeVos;
    List<Date> dates;
}
