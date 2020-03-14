package com.lnsf.vo;

import com.lnsf.dto.OrderListDTO;
import lombok.Data;

import java.util.List;

@Data
public class MyOrderVO {
    private List<OrderListDTO> orderAll;
    private List<OrderListDTO> orderNotPay;
    private List<OrderListDTO> orderNotIn;
    private List<OrderListDTO> orderComment;

    private Integer orderAllNum;
    private Integer orderNotPayNum;
    private Integer orderNotInNum;
    private Integer orderCommentNum;


}
