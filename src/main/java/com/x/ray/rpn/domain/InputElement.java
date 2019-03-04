package com.x.ray.rpn.domain;

import java.math.BigDecimal;

import com.x.ray.rpn.constants.InputType;
import com.x.ray.rpn.exception.IllegalInputException;
import com.x.ray.rpn.process.Context;
import com.x.ray.rpn.supports.OperatorSupport;

/**
 * 输入项
 *
 * @author lay 2019-03-04
 */
public class InputElement {
    /**
     * 输入的字符串
     */
    String value;
    /**
     * 位置，空格也算一个输入
     */
    int pos;
    /**
     * 输入类型
     */
    InputType inputType;
    /**
     * 数字
     */
    BigDecimal number;



    public static InputElement wrap(String value, Context context) throws IllegalInputException {
        if(value == null || value.length() == 0){
            throw new IllegalInputException("input value is null");
        }

        InputElement element = new  InputElement();

        if(" ".equals(value)){
            element.inputType = InputType.WHITESPACE;
        }else if(OperatorSupport.getInstance().isSupport(value)){
            element.inputType = InputType.OPERATOR;
        } else {
            try{
                element.number = new BigDecimal(value);
            }catch (Exception e){
                throw new IllegalInputException("input value is not correct number:" + value);
            }
            element.inputType = InputType.NUMBER;
        }

        element.pos = context.getCurInputPos() + 1;
        element.value = value;

        context.setCurVal("");

        return element;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public InputType getInputType() {
        return inputType;
    }

    public void setInputType(InputType inputType) {
        this.inputType = inputType;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }
}
