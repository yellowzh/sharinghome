package com.lnsf.util;

import cn.hutool.core.date.DateUtil;
import com.lnsf.controller.LoginController;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Random;

public class UploadImgUtil {
    private static Logger log = Logger.getLogger(LoginController.class);

    /*@RequestMapping("/upload")
    @ApiOperation(value = "上传图片", notes = "上传图片",httpMethod = "POST")*/
    public static Map<String,Object> uplond(MultipartFile file, Map<String,Object> map)throws Exception{
        // 拿到原文件名
        String filePath = file.getOriginalFilename();
        /*重新生成的文件名==日期*/
        String path="mp"+ DateUtil.today().replace("-","");
        /*重组文件名*/
        String extendName = filePath.substring(filePath.lastIndexOf("."), filePath.length());
        /*生成一个5位数的随机数*/
        int radom = new Random().nextInt(99999);
        if (radom < 10000) {
            radom += 10000;
        }
        String fileName = path+radom+extendName;
        log.info("uuid："+radom);
        // 存放上传图片的文件夹
        File fileDir = UploadUtils.getImgDirFile();
        // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
        log.info("文件路径1："+fileDir);
//        File fileDir2 = FileUtil.file(fileDir);
        log.info("filePath："+filePath);
        log.info("path："+path);
        log.info("fileName："+fileName);
//        log.info("fileDir2.getAbsoluteFile() ："+fileDir2);
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileDir.getAbsoluteFile() + File.separator+fileName));
        outputStream.write(file.getBytes());
        outputStream.flush();
        outputStream.close();
        map.put("filename", "/uploads/"+fileName);
        map.put("size", file.getSize());
        map.put("photoId", path+radom);
        map.put("name", filePath);
        map.put("type", file.getContentType());
        return map;
    }

}
