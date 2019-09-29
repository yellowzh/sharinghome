package com.lnsf.sharinghome;

import com.lnsf.bean.Homeshow;
import com.lnsf.bean.Login;
import com.lnsf.service.HomeShowService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SharinghomeApplicationTests {
    @Autowired
    private HomeShowService homeShowService;
    @Test
    public void contextLoads() {
        /*查看所有房源信息*/
        List<Homeshow> homeShowList = homeShowService.getAllHomeShow();
        System.out.println(homeShowList);
    }

    @Test
    public void login(){
        /*登录模块*/
        Login login = new Login();
        login.setUsername("huang");
        login.setPassword("12345");


    }
}
