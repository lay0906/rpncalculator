package com.x.ray.rpn.operator;

import com.x.ray.rpn.process.Context;
import com.x.ray.rpn.constants.OpTypeAnno;

/**
 * 清空
 *
 * @author lay 2019-03-04
 */
@OpTypeAnno(opcode = "clear")
public class ClearOperator implements Operator {

    public void operateInternal(Context context) {
        context.clear();
    }

    @Override
    public boolean check(Context context) {
        return true;
    }

    @Override
    public void genLastStep(Context context) {
        context.getLastStepList().clear();
    }
}
