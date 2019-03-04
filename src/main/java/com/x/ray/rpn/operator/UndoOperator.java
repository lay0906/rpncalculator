package com.x.ray.rpn.operator;

import com.x.ray.rpn.constants.InputType;
import com.x.ray.rpn.constants.OpTypeAnno;
import com.x.ray.rpn.domain.InputElement;
import com.x.ray.rpn.domain.LastStep;
import com.x.ray.rpn.process.Context;

/**
 * 回滚
 *
 * @author lay 2019-03-04
 */
@OpTypeAnno(opcode = "undo")
public class UndoOperator implements Operator {
    @Override
    public void operateInternal(Context context) {
        if(context.getLastStepList().size() == 0){
            return;
        }

        LastStep step = context.getLastStepList().remove(context.getLastStepList().size() - 1);
        if(step.getInputType() == InputType.NUMBER){
            context.pop();
            return;
        }

        if(step.getInputType() == InputType.OPERATOR){
            context.pop();
            for(InputElement element : step.getInputElementList()){
                context.push(element);
            }
        }
    }

    @Override
    public boolean check(Context context) {
        return true;
    }

    @Override
    public void genLastStep(Context context) {
    }
}
