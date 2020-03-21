package com.lnsf.vo;

import com.lnsf.dto.ArticleDTO;
import com.lnsf.dto.OrderListDTO;
import com.lnsf.entity.ArticleEntity;
import lombok.Data;

import java.util.List;

@Data
public class ArticleListVO {
    private List<ArticleDTO> articleEntities;
    private Long indexPage;
    private Long totalPage;
}
