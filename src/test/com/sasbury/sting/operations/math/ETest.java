package test.com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import test.com.sasbury.sting.*;

public class ETest extends PushOpTest
{
    public ETest(String name)
    {
        super(name);
    }
    
    public String getOperationName()
    {
        return E;
    }

    public StingStack getCorrectStack(ExecutionContext context)
    {
        StingStack stack = new StingStack();
        stack.push(new StingNumber(Math.E));
        return stack;
    }
}
