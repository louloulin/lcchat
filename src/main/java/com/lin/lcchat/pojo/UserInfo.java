/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.lcchat.pojo;

/**
 * 类名称: UserInfo <br>
 * 类描述: <br>
 *
 * @author: chong.lin
 * @date: 2018/1/19 上午10:35
 * @company: 易宝支付(YeePay)
 */
public class UserInfo {
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}