package com.x.ray.rpn.domain;

import java.util.ArrayList;
import java.util.List;

import com.x.ray.rpn.constants.InputType;

/**
 * 用于回滚undo
 *
 * @author lay 2019-03-04
 */
public class LastStep {
    private InputType inputType;
    private List<InputElement> inputElementList = new ArrayList<InputElement>();

    public InputType getInputType() {
        return inputType;
    }

    public void setInputType(InputType inputType) {
        this.inputType = inputType;
    }

    public List<InputElement> getInputElementList() {
        return inputElementList;
    }

    public void setInputElementList(List<InputElement> inputElementList) {
        this.inputElementList = inputElementList;
    }
}
