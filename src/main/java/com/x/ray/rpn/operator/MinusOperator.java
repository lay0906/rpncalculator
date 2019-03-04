package com.x.ray.rpn.operator;

import java.math.BigDecimal;

import com.x.ray.rpn.domain.InputElement;
import com.x.ray.rpn.process.Context;
import com.x.ray.rpn.constants.OpTypeAnno;

/**
 * 减
 *
 * @author lay 2019-03-04
 */
@OpTypeAnno(opcode = "-")
public class MinusOperator implements Operator {

    public void operateInternal(Context context) {
        BigDecimal a = context.getStack().pop().getNumber();
        BigDecimal b = context.getStack().pop().getNumber();


        InputElement element = InputElement.wrap(String.valueOf(b.subtract(a)), context);
        context.push(element);
    }
}
