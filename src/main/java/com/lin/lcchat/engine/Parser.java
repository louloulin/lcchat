/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.lcchat.engine;

import com.lin.lcchat.engine.bean.TemplateBean;

/**
 * 类名称: Parser <br>
 * 类描述: 解析接口<br>
 *
 * @author: chong.lin
 * @date: 2018/1/26 上午10:57
 * @company: 易宝支付(YeePay)
 */
public interface Parser<T> {
    /**
     * 解析
     */
    <T> T parser();
}