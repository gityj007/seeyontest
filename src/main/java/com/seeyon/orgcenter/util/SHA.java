package com.seeyon.orgcenter.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * <p>
 *  加密工具类
 * </p>
 *
 * @author yangjian
 * @since 2020-10-11
 */
public class SHA {
    public static final String KEY_SHA = "SHA";
    public static String getCode(String inputStr) {
        BigInteger sha = null;
        byte[] inputData = inputStr.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sha.toString();
    }

}