/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.lcchat.engine.bean;

/**
 * 类名称: Language <br>
 * 类描述: <br>
 *
 * @author: chong.lin
 * @date: 2018/1/26 上午11:59
 * @company: 易宝支付(YeePay)
 */
public class Language {
    private String language;
    private String alias;
    private String trait;
    private String weakness;

    public Language(String language, String alias, String trait, String weakness) {
        this.language = language;
        this.alias = alias;
        this.trait = trait;
        this.weakness = weakness;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }
}