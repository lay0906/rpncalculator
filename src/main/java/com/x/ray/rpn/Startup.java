package com.x.ray.rpn;

import java.util.Scanner;

import com.x.ray.rpn.utils.Log;
import com.x.ray.rpn.process.Processor;
import com.x.ray.rpn.supports.OperatorSelector;

/**
 * 计算器-启动器
 *
 * @author lay 2019-03-04
 */
public class Startup {

    public static void main(String[] args) {
        OperatorSelector.getInstance().init();
        Log.warn("init finished please input expr!");

        Scanner sc = new Scanner(System.in);
        while (true){
            String expr = sc.nextLine();
            if("quit".equals(expr)){
                Log.warn("quit success");
                break;
            }
            Processor processor = new Processor();
            processor.process(expr);
            System.out.println();
        }
    }
}
