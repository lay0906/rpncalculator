package com.x.ray.rpn.supports;

import org.junit.Assert;
import org.junit.Test;

public class OperatorSelectorTest {

    @Test
    public void testInit(){
        OperatorSelector.getInstance().init();
        Assert.assertNotNull(OperatorSelector.getInstance().getOperator("+"));
        Assert.assertNotNull(OperatorSelector.getInstance().getOperator("-"));
        Assert.assertNotNull(OperatorSelector.getInstance().getOperator("*"));
        Assert.assertNotNull(OperatorSelector.getInstance().getOperator("/"));
        Assert.assertNotNull(OperatorSelector.getInstance().getOperator("sqrt"));
        Assert.assertNotNull(OperatorSelector.getInstance().getOperator("undo"));
        Assert.assertNotNull(OperatorSelector.getInstance().getOperator("clear"));

        Assert.assertNull(OperatorSelector.getInstance().getOperator("$"));
    }
}
