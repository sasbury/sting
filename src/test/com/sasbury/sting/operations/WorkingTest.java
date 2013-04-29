package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import test.com.sasbury.sting.*;

public class WorkingTest extends PushOpTest
{
    public WorkingTest(String name)
    {
        super(name);
    }
    
    public String getOperationName()
    {
        return WORKING;
    }

    public StingStack getCorrectStack(ExecutionContext context)
    {
        StingStack stack = new StingStack();
        stack.push(context.getWorking());
        return stack;
    }
}
