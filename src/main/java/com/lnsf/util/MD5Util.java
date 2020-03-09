package com.lnsf.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.security.MessageDigest;

public class MD5Util {
    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();    }
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
    /**     * 返回大写MD5
     * *
     * * @param origin
     * * @param charsetname
     * * @return
     * */
    private static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            }
            else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception exception) {

        }
        return resultString.toUpperCase();
    }



    public static String shiroEncryptionPwd(String originalPwd,String account){
        //散列算法需要四个参数
        //  1.指明算法的名称是  MD5
        //  2.需要用户注册表单填写的原始密码
        //  3.盐值，由于不同用户一旦拥有相同的秘密，加密之后的字段会一样，为了避免这个情况，加入了用户id这个盐值
        //  4.加密次数相当于 md5(md5(md5("")))进行1024次,=================>这个参数可以写定1024次，也可以用户自己定义次数
        //  用用户account生产盐值
        Object salt = ByteSource.Util.bytes(account);
        SimpleHash simpleHash = new SimpleHash("MD5",originalPwd,salt,1024);
        String endPwd = simpleHash.toString();
        return endPwd;
    }

    public static String MD5EncodeUtf8(String origin) {

        // origin = origin + PropertiesUtil.getProperty("password.salt", "");
        return MD5Encode(origin, "utf-8");    }
    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
}


