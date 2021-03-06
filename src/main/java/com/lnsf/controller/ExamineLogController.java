package com.lnsf.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lnsf.entity.UserInfoEntity;
import com.lnsf.service.UserInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lnsf.entity.ExamineLogEntity;
import com.lnsf.service.ExamineLogService;
import java.util.List;
import java.util.Random;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lnsf.dto.ExamineLogDTO;
import javax.validation.Valid;



/**
 *  前端控制器
 *
 * @author 黄润志
 * @since 2020-03-23 11:55
 */

@Api(tags = "")
@RestController
@RequestMapping("/api")
public class ExamineLogController {

    @Autowired
    private ExamineLogService examineLogService;
    @Autowired
    private UserInfoService userInfoService;

    /*审核邮件发送*/
    /*商家审核*/
    @ApiOperation("审核房源")
    @PostMapping("/Examine")
    @CacheEvict(value = "findAllHouses",allEntries = true)
    public String Examine(@RequestBody ExamineLogDTO examineLogDTO,int num){
        System.out.println("页面传值："+num);
        String text="尊敬的"+examineLogDTO.getHousesUser()+"您好！";
        if (num==1){
            examineLogDTO.setExamineStatus("审核通过");
            text=text+"恭喜您申请的房源出租已经审核通过！可登陆系统点击我的房源可以查看到您的房源信息，祝您生活愉快!";
        }else{
            examineLogDTO.setExamineStatus("驳回");
            text=text+"很抱歉您申请的商家账号已经被驳回！驳回原因为:"+examineLogDTO.getExamineReson();
        }
        /*审核信息插入*/
        ExamineLogEntity examineLogEntity = new ExamineLogEntity();
        /*原因更改*/
        examineLogEntity.setExamineReson(text);
        /*更新审核表，插入用户表，更新用户信息表，插入信息表*/
        ExamineLogEntity entity = examineLogService.create(examineLogDTO);
        String cc;
        if (null != entity){
            UserInfoEntity userInfoEntity = new UserInfoEntity();
            userInfoEntity.setUsername(examineLogDTO.getHousesUser());
            UserInfoEntity user = userInfoService.findUser(userInfoEntity);
            user.setUserPower(2+"");
            userInfoService.updateUser(user);
            cc =  sendMail("民宿运营商管理通知",text,examineLogDTO.getUemail());
        }else{
            cc="插入不成功";
        }
        return cc;
    }

    /*邮箱设置以及发送*/
    private static Logger log = Logger.getLogger(ExamineLogController.class);
    /*发送者邮箱*/
    @Value("${mail.fromMail.sender}")
    private String sender;
    /*接受者邮箱*/
   /* @Value("${mail.fromMail.receiver}")
    private String receiver;*/
    @Autowired
    private JavaMailSender javaMailSender;
    /* *
     * @Description  /sendMail
     * @author 黄润志
     * @email 2570090478@qq.com
     * @method 发送文本邮件
     */
    public String sendMail(String subject, String text,String emain) {
        System.out.println(subject+text);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(emain);
        message.setSubject(subject);
        message.setText(text);
        try {
            javaMailSender.send(message);
            log.info("简单邮件已经发送。");
        } catch (Exception e) {
            log.error("发送简单邮件时发生异常！", e);
        }
        return "简单邮件已经发送";
    }

    /**
     * 获取重置密码需要的验证码
     * @return
     */
    @ApiOperation("获取重置密码需要的验证码")
    @GetMapping("/getVeCodeNum")
    public String getCode(String email) {
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);//生成短信验证码
        //将验证码 和 过期时间更新到数据库
        String text="您好！您的验证码是："+verifyCode+"您可以复制此验证码并返回至民宿系统，以验证您的邮箱。此验证码只能使用一次，在5分钟内有效。验证成功则自动失效。如果您没有进行上述操作，请忽略此邮件。";
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("您好!");
//        stringBuilder.append("您的验证码是：").append(verifyCode);
//        stringBuilder.append("您可以复制此验证码并返回至民宿系统，以验证您的邮箱。");
//        stringBuilder.append("此验证码只能使用一次，在5分钟内有效。验证成功则自动失效。");
//        stringBuilder.append("如果您没有进行上述操作，请忽略此邮件。");
        String dd =  sendMail("小智民宿--邮箱验证",text,email);

//        String dd = "简单邮件已经发送";
        System.out.println(dd);
        if ("简单邮件已经发送".equals(dd)){
            return  verifyCode;
        }else {
            return "-1";
        }

    }
}
