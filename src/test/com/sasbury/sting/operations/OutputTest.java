package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import test.com.sasbury.sting.*;

public class OutputTest extends PushOpTest
{
    public OutputTest(String name)
    {
        super(name);
    }
    
    public String getOperationName()
    {
        return OUTPUT;
    }

    public StingStack getCorrectStack(ExecutionContext context)
    {
        StingStack stack = new StingStack();
        stack.push(context.getOutput());
        return stack;
    }
}
