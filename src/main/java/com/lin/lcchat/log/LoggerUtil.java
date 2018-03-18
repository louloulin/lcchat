/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.lcchat.log;


import com.lin.lcchat.log.impl.Log4jLogAdapter;
import com.lin.lcchat.log.impl.SystemLogAdapter;
import com.lin.lcchat.plugin.SimplePluginManager;

/**
 * 类名称: LoggerUtil <br>
 * 类描述: <br>
 *
 * @author: chong.lin
 * @date: 2018/2/2 下午3:26
 * @company: 易宝支付(YeePay)
 */
public  class LoggerUtil {
    private static   Log logger = Logs.get();
    private static LogAdapter adapter;

    static {
        init();
    }
    /**
     * 初始化NutLog,检查全部Log的可用性,选择可用的Log适配器
     * <p/>
     * <b>加载本类时,该方法已经在静态构造函数中调用,用户无需主动调用.</b>
     * <p/>
     * <b>除非迫不得已,请不要调用本方法<b/>
     * <p/>
     */
    public static void init() {
        try {
            String packageName = Logs.class.getPackage().getName() + ".impl.";
            adapter = new SimplePluginManager<LogAdapter>(
                    packageName + "CustomLogAdapter",
                    packageName + "Slf4jLogAdapter",
                    packageName + "Log4jLogAdapter",
                    packageName + "SystemLogAdapter").get();
        }
        catch (Throwable e) {
            try {
                Log4jLogAdapter tmp = new Log4jLogAdapter();
                if (tmp.canWork())
                    adapter = tmp;
                else
                    adapter = new SystemLogAdapter();
            } catch (Throwable _e) {
                adapter = new SystemLogAdapter();
            }
        }
    }
    public static void info(String message){
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        logger = getLogger();
        if(logger == null ){
            logger =   adapter.getLogger(sts[2].getClassName());
        }
        logger.info(message);
    }

    public static Log getLogger() {
        return logger;
    }

    /**
     * 开放自定义设置LogAdapter,注意,不能设置为null!! 如果你打算完全禁用Nutz的log,可以设置为NOP_ADAPTER
     * @param adapter 你所偏好的LogAdapter
     */
//    public static void setAdapter(LogAdapter adapter) {
//        LoggerUtil.adapter = adapter;
//    }
//    public static LogAdapter NOP_ADAPTER = NopLog.NOP;

    public static void main(String[] args) {
        logger.info("ewewe");
    }
}