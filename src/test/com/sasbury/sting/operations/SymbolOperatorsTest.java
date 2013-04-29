package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import test.com.sasbury.sting.*;

public class SymbolOperatorsTest extends OperationTest
{
    public SymbolOperatorsTest(String name)
    {
        super(name);
    }
    
    public String getOperationName()
    {
        return "+";
    }

    public String getProgram()
    {
        return "1 1 + 1 - 4 * 2 / 6 %";
    }

    public StingStack getCorrectStack()
    {
        StingStack goodAnswer = new StingStack();
        goodAnswer.push(new StingNumber(2));
        return goodAnswer;
    }
}
