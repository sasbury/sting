package com.sasbury.sting.operations;

import com.sasbury.sting.*;

public class Working implements StingOperation,StingConstants
{
    public String toString()
    {
        return WORKING;
    }
    
    public StingOperation copy()
    {
        return new Working();
    }

    public boolean execute(ExecutionContext context)
    {
        context.getStack().push(context.getWorking());
        return true;
    }
}
