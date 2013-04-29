package com.sasbury.sting.operations;

import com.sasbury.sting.*;

public class Input implements StingOperation,StingConstants
{
    public String toString()
    {
        return INPUT ;
    }

    public StingOperation copy()
    {
        return new Input();
    }

    public boolean execute(ExecutionContext context)
    {
        context.getStack().push(context.getInput());
        return true;
    }
}
