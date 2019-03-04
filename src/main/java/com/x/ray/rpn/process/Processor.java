package com.x.ray.rpn.process;

import com.x.ray.rpn.Utils.Log;
import com.x.ray.rpn.constants.InputType;
import com.x.ray.rpn.domain.InputElement;
import com.x.ray.rpn.domain.LastStep;
import com.x.ray.rpn.exception.IllegalInputException;
import com.x.ray.rpn.operator.Operator;
import com.x.ray.rpn.supports.OperatorSelector;

/**
 * 执行器
 *
 * @author lay 2019-03-04
 */
public class Processor {

    private Context context;

    public Processor(){
        context = new Context();
    }

    public Processor(Context context){
        this.context = context;
    }

    public void process(String expr){
        for(String s : expr.split(" ")){
            if(!processInternal(s)){
                return;
            }
            processInternal(" ");
        }
        // call end
        processInternal(System.lineSeparator());
    }

    private boolean processInternal(String value) throws RuntimeException{
        context.append(value);

        InputElement input;
        // 1. 校验输入
        try {
            input = InputElement.wrap(value, context);
        } catch (IllegalInputException e) {
            Log.warn(String.format("input %s (position: %d): illegal input", value, context.getCurInputPos()));
            throw new RuntimeException(e);
        }


        if(input.getInputType() == InputType.NUMBER) {
            context.push(input);
            LastStep step = new LastStep();
            step.setInputType(InputType.NUMBER);
            step.getInputElementList().add(input);

            context.getLastStepList().add(step);
            return true;
        }else if(input.getInputType() == InputType.WHITESPACE){
            return true;
        }

        Operator operator = OperatorSelector.getInstance().getOperator(value);
        return operator.operate(context);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
}
