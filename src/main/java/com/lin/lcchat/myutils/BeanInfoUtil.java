package com.lin.lcchat.myutils;

import com.lin.lcchat.pojo.UserInfo;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
 
public class BeanInfoUtil { 
  
  public static void setProperty(UserInfo userInfo, String userName)throws Exception{
    PropertyDescriptor propDesc=new PropertyDescriptor(userName,UserInfo.class);
    Method methodSetUserName=propDesc.getWriteMethod();
    methodSetUserName.invoke(userInfo, "wong");
    System.out.println("set userName:"+userInfo.getUsername());
  }
  
  public static void getProperty(UserInfo userInfo,String userName)throws Exception{
    PropertyDescriptor proDescriptor =new PropertyDescriptor(userName,UserInfo.class);
    Method methodGetUserName=proDescriptor.getReadMethod();
    Object objUserName=methodGetUserName.invoke(userInfo);
    System.out.println("get userName:"+objUserName.toString());
  }

  public static void main(String[] args) throws Exception {
    UserInfo  userInfo = new UserInfo();
    BeanInfoUtil.setProperty(userInfo,"username");
    System.out.println(userInfo);
    BeanInfoUtil.getProperty(userInfo,"username");
  }
} 