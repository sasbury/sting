package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import test.com.sasbury.sting.*;

public class InputTest extends PushOpTest
{
    public InputTest(String name)
    {
        super(name);
    }
    
    public String getOperationName()
    {
        return INPUT;
    }

    public StingStack getCorrectStack(ExecutionContext context)
    {
        StingStack stack = new StingStack();
        stack.push(context.getInput());
        return stack;
    }
}
