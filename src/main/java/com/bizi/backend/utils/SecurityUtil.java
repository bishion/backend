package com.bizi.backend.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import java.security.MessageDigest;
/**
 * Created by guo on 16-10-5.
 */
@Slf4j
public class SecurityUtil {
    public static String md5Enc(String message){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(message.getBytes());
            return new String(Base64.encodeBase64(messageDigest.digest()));
        } catch (Exception e) {
            log.error("md5加密失败,原文:{}",message,e);
        }
        return null;
    }
}