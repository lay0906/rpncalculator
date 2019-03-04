package com.x.ray.rpn.process;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.x.ray.rpn.domain.InputElement;
import com.x.ray.rpn.domain.LastStep;

/**
 * 执行上下文
 *
 * @author lay 2019-03-04
 */
public class Context {
    /**
     * 运算栈
     */
    private Stack<InputElement> stack = new Stack<InputElement>();
    /**
     * 当前位置，包含空格，用于错误提示
     */
    private int curInputPos = 0;
    /**
     * 输入表达式
     */
    String inputStr;
    /**
     * 当前操作数
     */
    String curVal = "";
    /**
     * undo操作
     */
    List<LastStep> lastStepList = new ArrayList<LastStep>();


    public InputElement pop(){
        return stack.pop();
    }

    public void push(InputElement element){
        stack.push(element);
    }

    public void clear(){
        stack.clear();
        curInputPos = 0;
        inputStr = "";
        curVal = "";
    }


    public void append(String value){
        if(inputStr == null){
            inputStr = new String(value);
        }else {
            inputStr += value;
        }
        curVal = value;
        curInputPos += value.length();
    }

    public Stack<InputElement> getStack() {
        return stack;
    }

    public void setStack(Stack<InputElement> stack) {
        this.stack = stack;
    }

    public int getCurInputPos() {
        return curInputPos;
    }

    public void setCurInputPos(int curInputPos) {
        this.curInputPos = curInputPos;
    }

    public String getInputStr() {
        return inputStr;
    }

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
    }

    public String getCurVal() {
        return curVal;
    }

    public void setCurVal(String curVal) {
        this.curVal = curVal;
    }

    public List<LastStep> getLastStepList() {
        return lastStepList;
    }
}
