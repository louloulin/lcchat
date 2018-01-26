/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.lcchat.engine.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称: ResultBean <br>
 * 类描述: <br>
 *
 * @author: chong.lin
 * @date: 2018/1/26 下午12:52
 * @company: 易宝支付(YeePay)
 */
public class ResultBean extends TemplateBean  {
    private List<List<String>> tbodys = new ArrayList<>();

    public List<List<String>> getTbodys() {
        return tbodys;
    }

    public void setTbodys(List<List<String>> tbodys) {
        this.tbodys = tbodys;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "tbodys=" + tbodys +
                '}';
    }

    public static void main(String[] args) {
        TemplateBean bean = new ResultBean();
    }
}