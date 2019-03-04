package com.x.ray.rpn.utils;

import java.math.BigDecimal;

/**
 * 数字格式化
 *
 * @author lay 2019-03-04
 */
public class NumberUtil {

    public static String toDecimal(BigDecimal v){
        String s = String.valueOf(v);
        int pointIndex = s.indexOf('.');
        if(pointIndex == -1){
            return s;
        }

        int pointSize = s.length() - pointIndex - 1;
        if(pointSize == 0){
            return s;
        }

        if(v.doubleValue() % 1 == 0){
            return String.valueOf(v.longValue());
        }

        if(pointSize >= 10){
           return s.substring(0, pointIndex) + s.substring(pointIndex, pointIndex + 11);

        }
        return s;
    }
}
