//package com.lnsf.config;
//
//import java.io.FileWriter;
//import java.io.IOException;
//
///**
//*@Description
//*@Author huangrunzhi
//*@Date 2020/3/12 9:58
//*/
///* *
// *类名：AlipayConfig
// *功能：基础配置类
// *详细：设置帐户有关信息及返回路径
// */
//public class AlipayConfig {
//
////↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
//
//    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
//    public static String app_id = "2016101800717146";
//
//    // 商户私钥，您的PKCS8格式RSA2私钥
//    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCHO7AJWPAiMLf2UgxVvkie9ChO50NUxgslYidJ+/K2N8NA+6uAcax74DWTwxndthTgntqdTVeuAhzbDHejpKvDmT8NA4Bh+xd6kSWR3YeFJ2d6AJPGRWIqc062mXKvpaf6klc+4H5iCoYVWaCSikBu7/guOG1AXyZFPr5Vatp5nvdjfq3AFlZbK4JtYSZn7eFntuTVlIltMo5jwHzRXVLbhxKFiLTlikCutZ0mWEUkBYPlP6iE1MMqtq6HFAGch570LXC5eUJ1nydY2ik14N6S0IcGfaLUP769f6htibQbeSaHAQ9nY/V+XyKG0ztoF26pf0H/6rT+vALIygmsib6TAgMBAAECggEABENbb1AAcfN7OSapAOL4wxoLU0FzG+8KVulbN7fblOb5HslQRMJQn68XwUq7PAQLcHFRjvfrNa8XXchs1RnR2F6yYCSmHXCe8tw0hP6o0QfG+U+fWPbC+3ebGaKIvQTJ4NpQKclF8q1GQNIMf9If6d9iwYJB32+gczphIaw2qvLNzB63Kpwwl82uI95npclQV0p+KbcdPL1Mml0+RAT0MOEYttW8Y8ih2gDuYVXPTyhg4kcTrb3crWJcyT65a8GmLDfoUbSAMF8SOlgL/xIZU3x1UkbKIrBlCSCGBhpwjoHXMdlU02b5Z/Fks8DAmQcMrBIRaVvibDoVP+1Y8Ccj0QKBgQDz0KCidp4mBUVYJYqegIboGTTrxrVJXOegdWgx2yvyCE1zbRfp5WhgkhN/zlncdQb1EvlCdRgpmmGyUsgvbByOeiQVI84wywgQaDPMQnlrIEX5MMVdiOI0d6FAFjgsPQ8vRxvocJNTAtxQVIlmqFHD83rO7r06BaFI2n4r9VFxvwKBgQCN/dzktdjwJof/9X5dwCCTn/ASzke2imcDx/OZXWIsTrqKCgLbKyBvBrpahdE5ubB9JQ1nsd5/4jtwO8qfkusycdk2tQo+6OKZ3MpBTdjner7+AdF/WWzwb09FkX/KqdOTKwNNiI8cDKK1zX4T+JEqcsQUeFvZoJG+4tKS73dALQKBgCNdZY9rKTFWnmJUv7CR7/+GeHiij/UeNrK9lOl2Yv9uWN2fO1K/5c3sIkvtgHdLukCeCe2r0l9mdzlIbKUER3gbG1S9ptDJAlhu5OSB197EBaJJgrc4facimw8Sqf8wtB0lcVTbz2LBDXfRa0SqsYF8tZmCY4wg+O36U0bJBJE9AoGBAIOBX8ju5qmcdg7INi3r2AABe95e8CoOytPEp0ceJuN0Uu2v0e9cZOCPMZ7PGvTElsGAxIaKRNDaHUSYC9R4xJ3mtU8mowOauuvXgfaze7T/iM5FrtqsXunbnWaIF/wCB3LgvmFbnXdT+Io6dI9YglH3EsUGp8LKJNHOz0nIwQBNAoGAQ1TMnWiVZcxu5sG+zMLTNStmCPeq5PpJt5BrxQpbpIjJgFEtXXIt/7sFYyfHmJWqJxvmcWWfcr1xoIUSjU2wPrscN7Z/gHC/ia/n2GJy6lNLINar4XixaUgBdKuNIsGYqZwKPIL8mtlN8lIQItnfwvqaQk9W1iFAeJOrFVyMjus=";
//
//    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
//    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyzDjB9t5249oXv2SEFNtRZjXc+ialBKc7N8zt5GjOgT7yBTwC4ZOe+5ikvbvbzswssndS+dq6aqyQ6gxupWgPykg+nZDxxgykBT5v3ZOmWJti+WL3RkHOL5NIYHWSkq6hmvFOaIqR1KdjxU4A5O2fvv1fgHcpH6i1fhUjq7eHd/Hpm9WKzDM/XPwiOpmOHGYSl71JgEjFt2IBjGWoIpmX6p5JEsOIsvSFUaC95rX9e8gyFOMP7LFtLLgDjpPiCfHhRAJTgsnrluRNg7rRJLabACMOJ+VzBhBnw2Po9YqAg6lc8QivVYf552wPy6enNWbPNToYzx/Y1ilnbmXETdkCQIDAQAB";
//
//    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    //public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";
//    public static String notify_url = "http://localhost:18080";//这里根据你项目中的controller进行配置
//
//    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    //public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
//    public static String return_url = "http://localhost:18080";//这里根据你项目中的controller进行配置
//
//    // 签名方式
//    public static String sign_type = "RSA2";
//
//    // 字符编码格式
//    public static String charset = "utf-8";
//
//    // 支付宝网关
//    //public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";//项目正式使用后使用
//    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";//使用沙箱环境时使用
//
//    // 支付宝网关
//    public static String log_path = "C:\\";
//
//
////↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
//
//    /**
//     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
//     * @param sWord 要写入日志里的文本内容
//     */
//    public static void logResult(String sWord) {
//        FileWriter writer = null;
//        try {
//            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
//            writer.write(sWord);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (writer != null) {
//                try {
//                    writer.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}