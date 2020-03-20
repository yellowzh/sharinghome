package com.lnsf.pay.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.lnsf.entity.OrderListEntity;
import com.lnsf.pay.properties.AlipayProperties;
import com.lnsf.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * 支付宝-电脑网站支付.
 * <p>
 * 电脑网站支付 https://docs.open.alipay.com/270/105898/
 *
 * @author huangrunzhi
 * @version 1.0
 * @since 2020/3/13
 */
@Controller
@RequestMapping("/alipay/page")
public class AlipayPagePayController {

    @Autowired
    private AlipayProperties alipayProperties;

    @Autowired
    private AlipayClient alipayClient;

    @Autowired
    private AlipayController alipayController;

    @Autowired
    private OrderListService orderListService;

    @PostMapping("/gotoPayPage")
    public void gotoPayPage(HttpServletResponse response,HttpServletRequest httpServletRequest) throws AlipayApiException, IOException {
        // 获取订单信息
        OrderListEntity orderListEntity = (OrderListEntity) httpServletRequest.getSession().getAttribute("oneOrder");

        String productCode = "FAST_INSTANT_TRADE_PAY";
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setOutTradeNo(orderListEntity.getOrderId()+"");//订单编号UUID.randomUUID().toString()
        model.setSubject("支付");
        model.setTotalAmount(orderListEntity.getOrderPrices()+"");//应支付金额
        model.setBody("支付，共"+orderListEntity.getOrderPrices()+"元");
        model.setProductCode(productCode);

        AlipayTradePagePayRequest pagePayRequest =new AlipayTradePagePayRequest();
        pagePayRequest.setReturnUrl("http://127.0.0.1:18080/alipay/page/returnUrl");
        pagePayRequest.setNotifyUrl(alipayProperties.getNotifyUrl());
        pagePayRequest.setBizModel(model);

        // 调用SDK生成表单, 并直接将完整的表单html输出到页面
        String form = alipayClient.pageExecute(pagePayRequest).getBody();
        response.setContentType("text/html;charset=" + alipayProperties.getCharset());
        response.getWriter().write(form);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping("/returnUrl")
    public String returnUrl(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, AlipayApiException {
        response.setContentType("text/html;charset=" + alipayProperties.getCharset());

        boolean verifyResult = alipayController.rsaCheckV1(request);
        if(verifyResult){
            //验证成功
            //请在这里加上商户的业务逻辑程序代码，如保存支付宝交易号
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            /*支付成功后修改订单支付状态*/
            OrderListEntity orderListEntity = (OrderListEntity) request.getSession().getAttribute("oneOrder");
            orderListService.update(orderListEntity);

            return "user/myorder";

        }else{
            return "user/pagePayFail";

        }
    }
}


