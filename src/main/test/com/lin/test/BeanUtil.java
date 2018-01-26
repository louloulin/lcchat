/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.test;


import java.beans.Beans;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 类名称: BeanUtil <br>
 * 类描述: <br>
 *
 * @author: chong.lin
 * @date: 2018/1/18 下午4:37
 * @company: 易宝支付(YeePay)
 */
public class BeanUtil {
    /**
     *
     * @param obj
     * @param property
     * @return
     */
    public static Object getProperty(Object obj, String property) {
        if (obj == null) {
            throw new IllegalArgumentException("no bean specified");
        }
        if (property == null) {
            throw new IllegalArgumentException("no property specified");
        }

        if (obj instanceof Map) {
            return ((Map) obj).get(property);
        }

        StringTokenizer st = new StringTokenizer(property, ".");
        if (st.countTokens() == 0) {
            return null;
        }

        Object result = obj;

        try {
            while (st.hasMoreTokens()) {
                String currentPropertyName = st.nextToken();
                if (result != null) {
                    result = PropertyUtils.getProperty(result,
                            currentPropertyName);
                }
            }
            return result;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 获取对象属性
     * @param obj
     * @param properties
     * @return
     */
    public static Map getProperties(Object obj, String[] properties) {
        if (obj == null) {
            throw new IllegalArgumentException("no bean specified");
        }
        if (properties == null) {
            throw new IllegalArgumentException("no priperties specified");
        }
        Map result = new LinkedHashMap();
        for (int i = 0; i < properties.length; i++) {
            Object value = getProperty(obj, properties[i]);
            result.put(properties[i], value);
        }
        return result;
    }
    public static void copyProperties(Object source, Object target,
                                      String[] properties, boolean convertType, boolean ignoreNullValue) {
        Map valueMap = getProperties(source, properties);

        Iterator keys = valueMap.keySet().iterator();
        while (keys.hasNext()) {
            String property = keys.next().toString();
            Object value = valueMap.get(property);
            copyProperty(target, property, value, convertType, ignoreNullValue);
        }
    }
    public static boolean copyProperty(Object obj, String property,
                                       Object value, boolean convertType, boolean ignoreNullValue) {
        if (obj == null) {
            throw new IllegalArgumentException("no bean specified");
        }
        if (property == null) {
            throw new IllegalArgumentException("no property specified");
        }
        if (ignoreNullValue && value == null) {
            return true;
        }

        if (obj instanceof Map) {
            return invokeSetter(obj, property, value, convertType,
                    ignoreNullValue);
        }

        StringTokenizer st = new StringTokenizer(property, ".");
        if (st.countTokens() == 0) {
            return false;
        }

        Object current = obj;
        try {
            while(st.hasMoreTokens()){
                String currentPropertyName = st.nextToken();
                if(st.hasMoreTokens()){
                    current = invokeGetter(current, currentPropertyName);
                }else {
                    try {
                        invokeSetter(current, currentPropertyName, value,
                                convertType, ignoreNullValue);
                    } catch (Exception e) {
                        return false;
                    }
                }
            }
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }
    /**
     * inject value into object
     * @param property target property
     * @param value injected object
     * @param autoConvert 是否需要自动转换类型
     * @param ingoreNullValue 是否自动忽略NULL值
     * @return
     */
    public static boolean invokeSetter(Object target, String property,
                                       Object value, boolean autoConvert, boolean ingoreNullValue) {
        if (target instanceof Map) {
            ((Map) target).put(property, value);
            return true;
        }
        Object newValue = null;
        if (autoConvert) {
            Class type = PropertyUtils
                    .getPropertyType(target.getClass(), property);
            if (Beans.isInstanceOf(value, type)) {
                newValue = value;
            } else if (value instanceof String) {
//                newValue = ConvertUtils.convert(type, (String) value);
            } else {
                newValue = value;
            }
        } else {
            newValue = value;
        }
        if (!ingoreNullValue || newValue != null) {
            boolean r = PropertyUtils.setProperty(target, property, newValue);
        }
        return true;
    }
    /**
     * get property from object
     * @param obj target object
     * @param property target property
     * @return
     */
    public static Object invokeGetter(Object obj, String property) {
        if (obj instanceof Map) {
            return ((Map) obj).get(property);
        } else {
            return PropertyUtils.getProperty(obj, property);
        }
    }

}
