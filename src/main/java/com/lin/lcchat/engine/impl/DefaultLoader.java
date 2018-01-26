/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.lcchat.engine.impl;

import com.lin.lcchat.engine.Loader;
import com.lin.lcchat.engine.bean.Language;
import com.lin.lcchat.engine.bean.ResultBean;
import com.lin.lcchat.engine.bean.TableBean;
import com.lin.lcchat.engine.bean.TemplateBean;
import com.lin.lcchat.engine.util.TemplateParserContext;
import com.lin.lcchat.utils.Iterables;
import org.springframework.beans.BeanUtils;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类名称: DefaultLoader <br>
 * 类描述: <br>
 *
 * @author: chong.lin
 * @date: 2018/1/26 下午12:04
 * @company: 易宝支付(YeePay)
 */
public class DefaultLoader implements Loader<TemplateBean> {
    private static Pattern r = Pattern.compile( "(\\$\\{)(\\w+)(\\})");

    /**
     * 可以优化
     * @param templateBean
     * @param languages
     * @return
     */
    public TemplateBean loader(TemplateBean templateBean, List languages) {
        TableBean table = templateBean.getTable();
        if(table == null){
            return templateBean;
        }
        List<String> tbody = table.getTbody();
        ExpressionParser parser = new SpelExpressionParser();
        languages.forEach(language -> {
            List<String> tb = new ArrayList<>();
            tbody.forEach(el->{
                String o = (String) parserEL(el, language);
                tb.add(o);
            });
           templateBean.getTable().getTbodyRes().add(tb);
        });
        return templateBean;
    }


    /**
     * 解析器
     * @param el
     * @param object
     * @return
     */
    private Object parserEL(String el,Object object){
        Object value = null;
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(object);
        Matcher m = r.matcher(el);
        if(m.matches()){
            context.lookupVariable(m.group(2));
            value  = parser.parseExpression(el, new TemplateParserContext()).getValue(context);
        }else {
            System.out.println("解析失败");
        }
        return value;
    }

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Language language1 = new Language("111","en","te","s");
        StandardEvaluationContext context = new StandardEvaluationContext(language1);

        context.lookupVariable("language");
        Object value = parser.parseExpression("${language}", new TemplateParserContext()).getValue(context);
        String str = "${1234234234}";
        System.out.println(value) ;
    }

}