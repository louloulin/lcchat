/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.lcchat.mdparser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 类名称: Test <br>
 * 类描述: <br>
 *
 * @author: chong.lin
 * @date: 2018/1/25 下午5:39
 * @company: 易宝支付(YeePay)
 */
public class Test {
    public static void main(String[] args) throws IOException {
        MdParser parser = new MdParser();
        parser.parserMd();
    }
}