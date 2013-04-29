package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import test.com.sasbury.sting.*;

public class PushNumberTest extends PushOpTest
{
    public PushNumberTest(String name)
    {
        super(name);
    }
    
    public String getOperationName()
    {
        return "5.555";
    }

    public StingStack getCorrectStack(ExecutionContext context)
    {
        StingStack stack = new StingStack();
        stack.push(new StingNumber("5.555"));
        return stack;
    }
}
