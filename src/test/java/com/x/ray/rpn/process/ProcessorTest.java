package com.x.ray.rpn.process;

import com.x.ray.rpn.supports.OperatorSelector;
import org.junit.Test;

public class ProcessorTest {

    @Test
    public void testCase1(){
        Processor processor = init();

        String expr = "5 2";
        processor.process(expr);
        System.out.println();
    }

    @Test
    public void testCase2(){
        Processor processor = init();

        String expr = "2 sqrt";
        processor.process(expr);
        System.out.println();
    }

    @Test
    public void testCase3(){
        Processor processor = init();

        String expr = "5 2 -";
        processor.process(expr);
        System.out.println();
    }

    @Test
    public void testCase4(){
        Processor processor = init();

        String expr = "5 2 - clear";
        processor.process(expr);
        System.out.println();
    }

    @Test
    public void testCase5(){
        Processor processor = init();

        String expr = "5 4 3 2 undo undo";
        processor.process(expr);
        System.out.println();
    }

    @Test
    public void testCase6(){
        Processor processor = init();

        String expr = "5 4 3 2 undo undo * 5 * undo";
        processor.process(expr);
        System.out.println();
    }

    @Test
    public void testCase7(){
        Processor processor = init();

        String expr = "7 12 2 /";
        processor.process(expr);
        System.out.println();
    }


    @Test
    public void testCase8(){
        Processor processor = init();

        String expr = "7 12 2 / * 4 /";
        processor.process(expr);
        System.out.println();
    }

    @Test
    public void testCase9(){
        Processor processor = init();

        String expr = "1 2 3 4 5 * * * *";
        processor.process(expr);
        System.out.println();
    }

    @Test
    public void testCase10(){
        Processor processor = init();

        String expr = "1 2 3 * 5 + * * 6 5";
        processor.process(expr);
        System.out.println();
    }


    @Test
    public void testCase11(){
        Processor processor = init();

        String expr = "1 *";
        processor.process(expr);
        System.out.println();
    }



    private Processor init(){
        OperatorSelector.getInstance().init();

        Context context = new Context();
        return new Processor(context);
    }
}
