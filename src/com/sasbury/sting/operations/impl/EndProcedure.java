package com.sasbury.sting.operations.impl;

import com.sasbury.sting.*;

public class EndProcedure implements StingOperation
{
    public String toString()
    {
        return END_PROCEDURE ;
    }

    public boolean execute(ExecutionContext context)
    {
        return true;
    }

    public StingOperation copy()
    {
        return new EndProcedure();
    }
}
