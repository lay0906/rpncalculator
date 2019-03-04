package com.x.ray.rpn.operator;

import com.x.ray.rpn.Utils.Log;
import com.x.ray.rpn.constants.InputType;
import com.x.ray.rpn.domain.LastStep;
import com.x.ray.rpn.process.Context;

/**
 * 运算器接口
 *
 * @author lay 2019-03-04
 */
public interface Operator {

    /**
     * 外部实现的运算逻辑
     *
     * @param context
     */
    void operateInternal(Context context);

    /**
     * 模板方法
     *
     * @param context
     * @return
     */
    default boolean operate(Context context){
        if(!check(context)){
            return false;
        }
        genLastStep(context);
        operateInternal(context);
        return true;
    }

    /**
     * 生成回滚日志
     *
     */
    default void genLastStep(Context context){
        LastStep step = new LastStep();
        step.setInputType(InputType.OPERATOR);

        int size = context.getStack().size();
        step.getInputElementList().add(context.getStack().elementAt(size - 2));
        step.getInputElementList().add(context.getStack().elementAt(size - 1));

        context.getLastStepList().add(step);
    }

    /**
     * 检查运算符是否有足够的操作数
     * @param context
     * @return
     */
    default boolean check(Context context){
        if(context.getStack().size() < 2){
            Log.warn(String.format("operator %s (position: %d): insufficient parameters", context.getCurVal(), context.getCurInputPos()));
            return false;
        }
        return true;
    }
}
