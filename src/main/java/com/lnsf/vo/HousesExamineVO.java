package com.lnsf.vo;

import com.lnsf.dto.ArticleDTO;
import com.lnsf.dto.HousesDTO;
import lombok.Data;

import java.util.List;
@Data
public class HousesExamineVO {
    private List<HousesDTO> housesDTOS;
    private Long indexPage;
    private Long totalPage;
}
