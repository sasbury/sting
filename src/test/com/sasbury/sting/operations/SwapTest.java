package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import test.com.sasbury.sting.*;

public class SwapTest extends OperationTest
{
    public SwapTest(String name)
    {
        super(name);
    }
    
    public String getOperationName()
    {
        return SWAP;
    }

    public String getProgram()
    {
        return "1.4 -3.7 swap 5 10 swap";
    }

    public StingStack getCorrectStack()
    {
        StingStack goodAnswer = new StingStack();
        goodAnswer.push(new StingNumber(-3.7));
        goodAnswer.push(new StingNumber(1.4));
        goodAnswer.push(new StingNumber(10));
        goodAnswer.push(new StingNumber(5));
        return goodAnswer;
    }
}
