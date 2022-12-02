package com.yacoding.internalcommon.util;

/**
 * @Author yaCoding
 * @create 2022-12-02 下午 8:07
 */

public class SsePrefixUtils {

    public static  final String sperator = "$";

    public  static String generatorSseKey(Long userId , String identity){
        return userId+sperator+identity;
    }

}
