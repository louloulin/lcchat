/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.lcchat.mdparser;

import com.google.common.base.Joiner;
import com.vladsch.flexmark.Extension;
import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.options.MutableDataSet;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类名称: MdParser <br>
 * 类描述: <br>
 *
 * @author: chong.lin
 * @date: 2018/1/25 下午5:35
 * @company: 易宝支付(YeePay)
 */
public class MdParser {
    public  void parserMd() throws IOException {
        // 从文件中读取markdown内容
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("test.md");
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "utf-8"));

        List<String> list = reader.lines().collect(Collectors.toList());
        String content = Joiner.on("\n").join(list);



// markdown to image
        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);
        options.set(Parser.EXTENSIONS, Arrays.asList(new Extension[] { TablesExtension.create()}));
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        Node document = parser.parse(content);
        String html = renderer.render(document);
        File newFile = new File("test.html");
        if(!newFile.exists()){
            newFile.createNewFile();
        }
        PrintStream printStream = new PrintStream(newFile);
        printStream.println(html);
    }
}