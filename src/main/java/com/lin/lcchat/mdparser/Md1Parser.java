/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.lcchat.mdparser;

import com.google.common.base.Joiner;
import org.pegdown.PegDownProcessor;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类名称: Md1Parser <br>
 * 类描述: <br>
 *
 * @author: chong.lin
 * @date: 2018/1/25 下午5:58
 * @company: 易宝支付(YeePay)
 */
public class Md1Parser {

        public static void main(String[]args){
            try {
               new Md1Parser().get();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


        public  String get()throws Exception{
            // 从文件中读取markdown内容
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream("test.md");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "utf-8"));

            List<String> list = reader.lines().collect(Collectors.toList());
            String content = Joiner.on("\n").join(list);

            PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
            String  html = pdp.markdownToHtml(content);
            File newFile = new File("test.html");
            if(!newFile.exists()){
                newFile.createNewFile();
            }
            PrintStream printStream = new PrintStream(newFile);
            System.out.println(html);
            return html;
        }
    }

