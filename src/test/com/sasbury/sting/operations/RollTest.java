package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import test.com.sasbury.sting.*;

public class RollTest extends OperationTest
{
    public RollTest(String name)
    {
        super(name);
    }
    
    public String getOperationName()
    {
        return ROLL;
    }

    public String getProgram()
    {
        return "1 2 3 4 4 1 roll 1 2 3 4 4 -2 roll";
    }

    public StingStack getCorrectStack()
    {
        StingStack goodAnswer = new StingStack();
        goodAnswer.push(new StingNumber(4));
        goodAnswer.push(new StingNumber(1));
        goodAnswer.push(new StingNumber(2));
        goodAnswer.push(new StingNumber(3));
        goodAnswer.push(new StingNumber(3));
        goodAnswer.push(new StingNumber(4));
        goodAnswer.push(new StingNumber(1));
        goodAnswer.push(new StingNumber(2));
        return goodAnswer;
    }
}
