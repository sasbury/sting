package com.sasbury.sting.operations;

import com.sasbury.sting.*;

public class Skip implements StingOperation,StingConstants
{
    public String toString()
    {
        return SKIP;
    }

    public StingOperation copy()
    {
        return new Skip();
    }

    /**
     * Execute the operation, returning true if successfull, false otherwise
     *
     * @param context
     * @return
     */
    public boolean execute(ExecutionContext context)
    {
        return true;
    }
}
