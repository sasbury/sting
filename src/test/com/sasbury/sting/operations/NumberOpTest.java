package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import test.com.sasbury.sting.*;

public abstract class NumberOpTest extends OperationTest
{
    double testCases[] = {-12,11,-3.7f,0,5.345f,(double)Math.PI,(double)Math.E};

    public abstract double operateOn(double one);

    public NumberOpTest(String name)
    {
        super(name);
    }
    
    public String getProgram()
    {
        StringBuffer buffer = new StringBuffer();

        for(int i=0,max=testCases.length;i<max;i++)
        {
            buffer.append(testCases[i]);
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
            goodAnswer.push(new com.sasbury.sting.types.StingNumber(operateOn(testCases[i])));
        }
        return goodAnswer;
    }
}
