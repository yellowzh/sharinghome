package com.lnsf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//新增加一个类用来添加虚拟路径映射
/*问题描述：页面上传图片文件，后台接收图片保存到本地，
返回保存路径，发现页面的<img\>标签无法显示图片，F12显示无法加载图片，
请求地址为ip:port/static/img（楼主将图片保存到了static下）
，显示404无此资源。将项目重新启动之后，图片可以正常加载。
解决方法：需要配置虚拟文件路径的映射*/
@Configuration
public class MyPicConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:./src/main/resources/static/uploads/");
    }
}

