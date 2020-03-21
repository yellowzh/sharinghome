package com.lnsf.pay.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.lnsf.pay.properties.AlipayProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 两个支付宝客户端，用户可以使用任意一个.
 *
 * alipay-trade-sdk 是对alipay-sdk-java的封装，建议使用alipay-trade-sdk.
 *
 * @author huangrunzhi
 */
@Configuration
@EnableConfigurationProperties(AlipayProperties.class)
public class AlipayConfiguration {

    @Autowired
    private AlipayProperties properties;

    /**
     * alipay-trade-sdk
     * @return
     */
  /*  @Bean
    public AlipayTradeService alipayTradeService() {
        return new AlipayTradeServiceImpl.ClientBuilder()
                .setGatewayUrl(properties.getGatewayUrl())
                .setAppid(properties.getAppid())
                .setPrivateKey(properties.getAppPrivateKey())
                .setAlipayPublicKey(properties.getAlipayPublicKey())
                .setSignType(properties.getSignType())
                .build();
    }
*/

    /**
     * alipay-sdk-java
     * @return
     */
    @Bean
    public AlipayClient alipayClient(){
        return new DefaultAlipayClient(properties.getGatewayUrl(),
                properties.getAppid(),
                properties.getAppPrivateKey(),
                properties.getFormate(),
                properties.getCharset(),
                properties.getAlipayPublicKey(),
                properties.getSignType());
    }
}

