/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.lcchat.engine;

/**
 * @author: chong.lin
 * @date: 2018/1/26 上午10:58
 * @company: 易宝支付(YeePay)
 */
public interface Render<T> {
    /**
     * 渲染
     */
    String render(T t);
}