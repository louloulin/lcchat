/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.test;

import junit.framework.TestCase;

/**
 * 类名称: MyTest <br>
 * 类描述: <br>
 *
 * @author: chong.lin
 * @date: 2018/1/18 下午4:39
 * @company: 易宝支付(YeePay)
 */
public class MyTest extends TestCase {
    public void test1(){
        Person person = new Person();
        person.setAge(11);
        person.setName("linc");
        String [] ss = {"age","name"};
        Object age = BeanUtil.getProperties(person,ss);
        System.out.println(age);
    }
    public void test2(){
        Person person = new Person();
        person.setName("lin");
        s(person);
        System.out.println(person);
        System.out.println("=====");
        Integer a = 1;
        s1(a);
        System.out.println(a);
        System.out.println("=====");
        int b = 1;
        s2(b);
        System.out.println(b);
        String s = "33";
        s3(s);
        System.out.println(s);
        String ss = new String("33");
        s3(ss);
        System.out.println(ss);

    }
    private void s(Person person){
        person.setAge(11);
    }
    private void s1(Integer a){
        a+=1;
    }
    private void s2(int a){
        a+=1;
    }
    private void s3(String a){
        a="1+"+a;
    }
}