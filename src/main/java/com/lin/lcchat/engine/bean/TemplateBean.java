/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.lcchat.engine.bean;

import java.util.Map;

/**
 * 类名称: TemplateBean <br>
 * 类描述: <br>
 *
 * @author: chong.lin
 * @date: 2018/1/26 上午11:10
 * @company: 易宝支付(YeePay)
 */
public class TemplateBean {
   private String title;
   private TableBean table;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TableBean getTable() {
        return table;
    }

    public void setTable(TableBean table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "TemplateBean{" +
                "title='" + title + '\'' +
                ", table=" + table +
                '}';
    }
}