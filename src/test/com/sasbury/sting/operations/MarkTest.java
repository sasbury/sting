package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import test.com.sasbury.sting.*;

public class MarkTest extends OperationTest
{
    public MarkTest(String name)
    {
        super(name);
    }
    
    public String getOperationName()
    {
        return MARK;
    }

    public String getProgram()
    {
        return "1.4 -3.7 mark 5 10 cleartomark";
    }

    public StingStack getCorrectStack()
    {
        StingStack goodAnswer = new StingStack();
        goodAnswer.push(new StingNumber(1.4));
        goodAnswer.push(new StingNumber(-3.7));
        return goodAnswer;
    }
}
