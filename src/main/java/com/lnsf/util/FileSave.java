package com.lnsf.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileSave {
    //localPath：保存的路径
    public static String fileSave(MultipartFile file, String localPath){
        System.out.println("保存路径："+localPath);
        //定义文件保存的本地路径
        if(!new File(localPath).exists()){
            new File(localPath).mkdirs();
        }
        //定义 文件名
        String filename=null;
        //判断是否为空
        if(!file.isEmpty()){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString();
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=file.getContentType();
            //获得文件后缀名
            String suffixName=contentType.substring(contentType.indexOf("/")+1);
            //得到文件名
            filename=uuid+"."+suffixName;
            //文件保存路径
            try {
                //将文件转移到指定位置
                file.transferTo(new File(localPath+filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return localPath+filename;
    }
}
