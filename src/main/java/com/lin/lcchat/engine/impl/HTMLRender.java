/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.lcchat.engine.impl;

import com.lin.lcchat.engine.Render;
import com.lin.lcchat.engine.bean.TableBean;
import com.lin.lcchat.engine.bean.TemplateBean;

import java.util.Arrays;
import java.util.List;

/**
 * 类名称: HTMLRender <br>
 * 类描述: <br>
 *
 * @author: chong.lin
 * @date: 2018/1/26 上午11:01
 * @company: 易宝支付(YeePay)
 */
public class HTMLRender implements Render<TemplateBean> {
    private static String  tbPrex = "<table border='1'  cellspacing='0' width: 200px; min-height: 25px; line-height: 25px; text-align: center; border-collapse: collapse;>\n";
    private static String  tbSub = "</table>\n";
    private static String trPrex = "<tr bgcolor=lightgrey>\n";
    private static String trSub = "</tr>\n";
    private static String td = "<td>%s</td>\n";
    @Override
    public String render(TemplateBean templateBean) {
        String title = templateBean.getTitle();
        String formatTitle = String.format("<h3>%s</h3>\n", title);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(formatTitle).append(tbPrex).append(trPrex);
        TableBean table = templateBean.getTable();
        if(table == null){
            return formatTitle;
        }
        List<String> th = table.getTh();
        String ths ="<td>" +String.join("</td>\n<td>", th)+"</td>\n";
        stringBuilder.append(ths).append("</tr>");
        List<List<String>> tbodyRes = table.getTbodyRes();
        tbodyRes.forEach(tbodyRe ->{
                 String s1 = "<tr >\n<td>" + String.join("</td>\n<td>",tbodyRe)+"</td>\n</tr>\n";
                 stringBuilder.append(s1);
                }
        );
        stringBuilder.append("</table>");
        return stringBuilder.toString();
    }
}