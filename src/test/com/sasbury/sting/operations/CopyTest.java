package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import test.com.sasbury.sting.*;

public class CopyTest extends OperationTest
{
    public CopyTest(String name)
    {
        super(name);
    }
    
    public String getOperationName()
    {
        return ROLL;
    }

    public String getProgram()
    {
        return "1 2 3 4 4 copy 1 2 3 4 2 copy";
    }

    public StingStack getCorrectStack()
    {
        StingStack goodAnswer = new StingStack();
        goodAnswer.push(new StingNumber(1));
        goodAnswer.push(new StingNumber(2));
        goodAnswer.push(new StingNumber(3));
        goodAnswer.push(new StingNumber(4));
        goodAnswer.push(new StingNumber(1));
        goodAnswer.push(new StingNumber(2));
        goodAnswer.push(new StingNumber(3));
        goodAnswer.push(new StingNumber(4));
        goodAnswer.push(new StingNumber(1));
        goodAnswer.push(new StingNumber(2));
        goodAnswer.push(new StingNumber(3));
        goodAnswer.push(new StingNumber(4));
        goodAnswer.push(new StingNumber(3));
        goodAnswer.push(new StingNumber(4));
        return goodAnswer;
    }
}
