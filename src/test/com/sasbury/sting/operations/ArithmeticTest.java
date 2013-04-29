package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import test.com.sasbury.sting.*;

public abstract class ArithmeticTest extends OperationTest
{
    double testCases[][] = {{11,15},{-3.7f,5},{-3.4f,5},{-3.4f,-2.4f},{0,5.345f},{(double)Math.PI,(double)Math.E}};

    public abstract double combine(double one,double two);

    public ArithmeticTest(String name)
    {
        super(name);
    }
    
    public String getProgram()
    {
        StringBuffer buffer = new StringBuffer();

        for(int i=0,max=testCases.length;i<max;i++)
        {
            buffer.append(testCases[i][0]);
            buffer.append(" ");
            buffer.append(testCases[i][1]);
            buffer.append(" ");
            buffer.append(getOperationName());
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public StingStack getCorrectStack()
    {
        StingStack goodAnswer = new StingStack();
        for(int i=0,max=testCases.length;i<max;i++)
        {
            goodAnswer.push(new com.sasbury.sting.types.StingNumber(combine(testCases[i][0],testCases[i][1])));
        }
        return goodAnswer;
    }
}
