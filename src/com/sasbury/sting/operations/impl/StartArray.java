package com.sasbury.sting.operations.impl;

import com.sasbury.sting.*;

public class StartArray implements StingOperation
{
    public String toString()
    {
        return START_ARRAY ;
    }

    public boolean execute(ExecutionContext context)
    {
        context.getStack().mark();
        context.incrementCurrentDepth();
        return true;
    }

    public StingOperation copy()
    {
        return new StartArray();
    }
}
