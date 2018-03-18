package com.lin.lcchat.log.impl;


import com.lin.lcchat.log.LoggerUtil;

/**
 *
 * @author wendal
 */
public class LogInfo {

    String message;
    
    Throwable e;

    public static void main(String[] args) {
        LoggerUtil.info("weewe");
        sd();
        sd1();
    }
    public static void sd(){
        LoggerUtil.info("wewewew");
    }
    public static void sd1(){
        LoggerUtil.info("weweweww2222");
    }
}
