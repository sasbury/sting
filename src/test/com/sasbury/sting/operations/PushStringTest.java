package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import test.com.sasbury.sting.*;

public class PushStringTest extends PushOpTest
{
    public PushStringTest(String name)
    {
        super(name);
    }
    
    public String getOperationName()
    {
        return "foo";
    }

    public StingStack getCorrectStack(ExecutionContext context)
    {
        StingStack stack = new StingStack();
        stack.push(new StingString("foo"));
        return stack;
    }
}
