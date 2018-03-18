package com.lin.lcchat.engine; /**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */

import com.lin.lcchat.engine.Parser;
import com.lin.lcchat.engine.bean.Language;
import com.lin.lcchat.engine.impl.DefaultLoader;
import com.lin.lcchat.engine.impl.HTMLRender;
import com.lin.lcchat.engine.impl.YamlParser;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称: TemplateEngine解析模版引擎 <br>
 * 类描述: <br>
 *
 * @author: chong.lin
 * @date: 2018/1/26 上午10:49
 * @company: 易宝支付(YeePay)
 */
public final class TemplateEngine{
    private Parser parser;
    private Loader loader = new DefaultLoader();
    private Render render = new HTMLRender();

    /**
     *初始化引擎
     */
    public TemplateEngine() {
    }

    /**
     * 初始化引擎
     * @param name
     */
    public void init(String name){
        this.parser = new YamlParser(name);
    }

    /**
     * 初始化引擎
     * @param parser
     * @param loader
     * @param render
     */
    public void init(Parser parser, Loader loader, Render render) {
        this.parser = parser;
        this.loader = loader;
        this.render = render;
    }


    /**
     * 处理器
     * @param s
     * @return
     */
    public String handler(List s){
        Object p = this.parser.parser();
        Object loader = this.loader.loader(p, s);
        String render = this.render.render(loader);
        return  render;
    }

    public static void main(String[] args) {
        TemplateEngine stringTemplateEngine = new TemplateEngine();
        stringTemplateEngine.init("email");
        List<Language> languages = new ArrayList<>();
        Language language1 = new Language("english","en","te","s");
        Language language2 = new Language("chinses","cn","ss","s");
        Language language3 = new Language("spains","sp","sp","p");
        Language language4 = new Language("franch","fc","fc","s");
        languages.add(language1);
        languages.add(language2);
        languages.add(language3);
        languages.add(language4);
        Object handler = stringTemplateEngine.handler(languages);
        System.out.println(handler);

    }
}