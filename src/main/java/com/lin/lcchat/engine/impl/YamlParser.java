/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.lcchat.engine.impl;
import com.lin.lcchat.engine.Parser;
import com.lin.lcchat.engine.bean.TemplateBean;
import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;


/**
 * 类名称: YamlParser <br>
 * 类描述: <br>
 *
 * @author: chong.lin
 * @date: 2018/1/26 上午10:58
 * @company: 易宝支付(YeePay)
 */
public class YamlParser implements Parser<TemplateBean> {
    private String name;

    public YamlParser(String name) {
        this.name = name;
    }

    @Override
    public TemplateBean parser() {
        return  mapToBean(this.name);
    }

    /**
     * 将yml模版映射成javaBean
     * @param name
     * @return
     */
    public TemplateBean mapToBean(String name){
        Yaml yaml = new Yaml();
        String format = String.format("email/%s.yml", name);
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(format);
        TemplateBean me = yaml.loadAs(stream, TemplateBean.class);
        return  me;
    }

    public static void main(String[] args) {
        Parser s = new YamlParser("email");
        System.out.println(s.parser());
    }
}