/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.lcchat.engine.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称: TableBean <br>
 * 类描述: <br>
 *
 * @author: chong.lin
 * @date: 2018/1/26 上午11:14
 * @company: 易宝支付(YeePay)
 */
public class TableBean {
    private List<String> th;
    private List<String> tbody;
    private List<List<String>> tbodyRes = new ArrayList<>();

    public List<String> getTh() {
        return th;
    }

    public void setTh(List<String> th) {
        this.th = th;
    }

    public List<String> getTbody() {
        return tbody;
    }

    public void setTbody(List<String> tbody) {
        this.tbody = tbody;
    }

    public List<List<String>> getTbodyRes() {
        return tbodyRes;
    }

    public void setTbodyRes(List<List<String>> tbodyRes) {
        this.tbodyRes = tbodyRes;
    }

    @Override
    public String toString() {
        return "TableBean{" +
                "th=" + th +
                ", tbody=" + tbody +
                ", tbodyRes=" + tbodyRes +
                '}';
    }
}