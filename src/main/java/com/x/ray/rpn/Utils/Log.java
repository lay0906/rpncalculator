package com.x.ray.rpn.Utils;

/**
 * 简单模拟一个log, 就不引入日志工具类了
 *
 * @author lay 2019-03-04
 */
public class Log {

    private static int ERROR = 3;
    private static int WARN = 2;
    private static int DEBUG = 1;

    /**
     * debug 1, warn 2, error,3
     */
    private static int LEVEL = 1;

    static {
        String LogLevel = System.getProperty("LogLevel", String.valueOf(DEBUG));
        try{
            LEVEL = Integer.parseInt(LogLevel);
        }catch (Exception e){
            LEVEL = 1;
        }
    }

    /**
     * 错误日志
     * @param msg
     */
    public static void error(String msg){
        if(ERROR >= LEVEL){
            System.err.println(msg);
        }
    }

    /**
     * warn
     * @param msg
     */
    public static void warn(String msg){
        if(WARN >= LEVEL){
            System.out.println(msg);
        }
    }

    /**
     * debug
     * @param msg
     */
    public static void debug(String msg){
        if(DEBUG >= LEVEL){
            System.out.println(msg);
        }
    }

    /**
     * warn
     * @param msg
     */
    public static void warnNotLine(String msg){
        if(WARN >= LEVEL){
            System.out.print(msg);
        }
    }
}
