package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import test.com.sasbury.sting.*;

public class PopTest extends OperationTest
{
    public PopTest(String name)
    {
        super(name);
    }
    
    public String getOperationName()
    {
        return POP;
    }

    public String getProgram()
    {
        return "1.4 -3.7 pop 5 10 pop";
    }

    public StingStack getCorrectStack()
    {
        StingStack goodAnswer = new StingStack();
        goodAnswer.push(new StingNumber(1.4));
        goodAnswer.push(new StingNumber(5));
        return goodAnswer;
    }
}
