package com.sasbury.sting.operations;

import com.sasbury.sting.*;

public class Mark implements StingOperation,StingConstants
{
    public String toString()
    {
        return MARK ;
    }

    public boolean execute(ExecutionContext context)
    {
        context.getStack().mark();
        return true;
    }

    public StingOperation copy()
    {
        return new Mark();
    }
}
