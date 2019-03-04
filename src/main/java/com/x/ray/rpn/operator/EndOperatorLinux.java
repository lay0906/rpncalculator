package com.x.ray.rpn.operator;

import com.x.ray.rpn.utils.Log;
import com.x.ray.rpn.utils.NumberUtil;
import com.x.ray.rpn.constants.InputType;
import com.x.ray.rpn.constants.OpTypeAnno;
import com.x.ray.rpn.domain.InputElement;
import com.x.ray.rpn.process.Context;

/**
 * end操作，打印栈
 *
 * @author lay 2019-03-04
 */
@OpTypeAnno(opcode = "\n")
public class EndOperatorLinux implements Operator {
    @Override
    public void operateInternal(Context context) {
        boolean first = true;
        if(context.getStack().isEmpty()){
            Log.warnNotLine("stack:");
            return;
        }

        for(int i = 0; i < context.getStack().size(); i++){
            InputElement element = context.getStack().elementAt(i);
            if(first){
                Log.warnNotLine("stack:");
            }else{
                Log.warnNotLine(" ");
            }
            if(element.getInputType() == InputType.NUMBER){
                Log.warnNotLine(NumberUtil.toDecimal(element.getNumber()));
            }else {
                Log.warnNotLine(element.getValue());
            }
            first = false;
        }
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
