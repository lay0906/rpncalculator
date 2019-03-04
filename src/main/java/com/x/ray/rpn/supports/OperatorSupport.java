package com.x.ray.rpn.supports;

import java.util.HashSet;

/**
 * 支持的运算符
 *
 * @author lay 2019-03-04
 */
public class OperatorSupport {

    private static OperatorSupport INSTANCE = new OperatorSupport();

    public static OperatorSupport getInstance(){
        return INSTANCE;
    }

    /**
     * 支持的运算符
     */
    private HashSet<String> supportOperators = new HashSet<String>();

    /**
     * 判断是否支持该运算符
     * @param operator
     * @return
     */
    public boolean isSupport(String operator){
        return supportOperators.contains(operator);
    }

    /**
     * 增加运算符
     * @param operator
     */
    public void addOperator(String operator){
        supportOperators.add(operator);
    }
}
