package com.sasbury.sting.operations.impl;

import com.sasbury.sting.*;

public class StartProcedure implements StingOperation
{
    public String toString()
    {
        return START_PROCEDURE ;
    }

    public boolean execute(ExecutionContext context)
    {
        return true;
    }

    public StingOperation copy()
    {
        return new StartProcedure();
    }
}
