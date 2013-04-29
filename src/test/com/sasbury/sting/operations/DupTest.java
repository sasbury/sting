package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import test.com.sasbury.sting.*;

public class DupTest extends OperationTest
{
    public DupTest(String name)
    {
        super(name);
    }
    
    public String getOperationName()
    {
        return DUP;
    }

    public String getProgram()
    {
        return "1.4 dup -3.7 dup";
    }

    public StingStack getCorrectStack()
    {
        StingStack goodAnswer = new StingStack();
        goodAnswer.push(new StingNumber(1.4));
        goodAnswer.push(new StingNumber(1.4));
        goodAnswer.push(new StingNumber(-3.7));
        goodAnswer.push(new StingNumber(-3.7));
        return goodAnswer;
    }
}
