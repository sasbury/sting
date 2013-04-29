package test.com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import test.com.sasbury.sting.*;

public class PiTest extends PushOpTest
{
    public PiTest(String name)
    {
        super(name);
    }
    
    public String getOperationName()
    {
        return PI;
    }

    public StingStack getCorrectStack(ExecutionContext context)
    {
        StingStack stack = new StingStack();
        stack.push(new StingNumber(Math.PI));
        return stack;
    }
}
