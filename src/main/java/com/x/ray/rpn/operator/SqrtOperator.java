package com.x.ray.rpn.operator;

import java.math.BigDecimal;

import com.x.ray.rpn.utils.Log;
import com.x.ray.rpn.constants.InputType;
import com.x.ray.rpn.domain.InputElement;
import com.x.ray.rpn.domain.LastStep;
import com.x.ray.rpn.process.Context;
import com.x.ray.rpn.constants.OpTypeAnno;

/**
 * 开方
 *
 * @author lay 2019-03-04
 */
@OpTypeAnno(opcode = "sqrt")
public class SqrtOperator implements Operator {

    public void operateInternal(Context context) {
        BigDecimal a = context.getStack().pop().getNumber();
        // ugly todo solve it
        InputElement element = InputElement.wrap(String.valueOf(Math.sqrt(a.doubleValue())), context);
        context.push(element);
    }

    @Override
    public boolean check(Context context) {
        if(context.getStack().size() < 1){
            Log.warn(String.format("operator %s (position: %d): insufficient parameters", context.getCurVal(), context.getCurInputPos() + 1));
            throw new RuntimeException("insufficient parameters");
        }
        return true;
    }


    @Override
    public void genLastStep(Context context) {
        LastStep step = new LastStep();
        step.setInputType(InputType.OPERATOR);

        int size = context.getStack().size();
        step.getInputElementList().add(context.getStack().elementAt(size - 1));

        context.getLastStepList().add(step);
    }
}
