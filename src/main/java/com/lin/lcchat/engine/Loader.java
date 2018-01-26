/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.lcchat.engine;

/**
 * 类名称: Loader <br>
 * 类描述: <br>
 *
 * @author: chong.lin
 * @date: 2018/1/26 下午12:03
 * @company: 易宝支付(YeePay)
 */
public interface Loader<T,S> {
    /**
     * 数据加载
     * @param t
     * @param s
     * @return
     */
    T loader(T t,S s);
}