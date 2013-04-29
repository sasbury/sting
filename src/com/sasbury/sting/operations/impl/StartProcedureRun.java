package com.sasbury.sting.operations.impl;

import com.sasbury.sting.*;

public class StartProcedureRun implements StingOperation
{
    public boolean execute(ExecutionContext context)
    {
        context.incrementCurrentDepth();
        return true;
    }

    public StingOperation copy()
    {
        return new StartProcedureRun();
    }
}
