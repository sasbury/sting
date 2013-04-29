package com.sasbury.sting.operations.impl;

import com.sasbury.sting.*;

public class EndProcedureRun implements StingOperation
{
    public boolean execute(ExecutionContext context)
    {
        context.decrementCurrentDepth();
        return true;
    }

    public StingOperation copy()
    {
        return new EndProcedureRun();
    }
}
