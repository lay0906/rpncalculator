package com.x.ray.rpn.supports;

import java.util.HashMap;
import java.util.Iterator;
import java.util.ServiceLoader;

import com.x.ray.rpn.constants.OpTypeAnno;
import com.x.ray.rpn.operator.Operator;

/**
 * 运算符操作类选择器
 *
 * @author lay 2019-03-04
 */
public class OperatorSelector {

    private static OperatorSelector INSTANCE = new OperatorSelector();

    public static OperatorSelector getInstance(){
        return INSTANCE;
    }

    private HashMap<String, Operator> operatorMap = new HashMap<String, Operator>();

    /**
     * 初始化
     */
    public void init(){
        ServiceLoader<Operator> operators = ServiceLoader.load(Operator.class);
        if(operators == null){
            throw new RuntimeException("init error: now operator support");
        }
        Iterator<Operator> iterator = operators.iterator();
        while (iterator.hasNext()){
            Operator operator = iterator.next();
            OpTypeAnno opTypeAnno = operator.getClass().getAnnotation(OpTypeAnno.class);
            OperatorSupport.getInstance().addOperator(opTypeAnno.opcode());
            operatorMap.put(opTypeAnno.opcode(), operator);
        }
        if(operatorMap.size() == 0){
            throw new RuntimeException("init error: now operator support");
        }
    }

    /**
     * 选择运算器
     * @param operator
     * @return
     */
    public Operator getOperator(String operator){
        return operatorMap.get(operator);
    }

}
