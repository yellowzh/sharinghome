package com.lnsf.vo;

import com.lnsf.dto.OrderListDTO;
import lombok.Data;

import java.util.List;
@Data
public class OrderListPageVO {
    private List<OrderListDTO> orderListDTOS;
    private Long indexPage;
    private Long totalPage;
}
