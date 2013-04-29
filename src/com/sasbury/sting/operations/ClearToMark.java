package com.sasbury.sting.operations;

import com.sasbury.sting.*;

public class ClearToMark implements StingOperation
{
    public String toString()
    {
        return CLEAR_TO_MARK;
    }

    public boolean execute(ExecutionContext context)
    {
        StingData[] data = context.getStack().popToMark();
        return true;
    }

    public StingOperation copy()
    {
        return new ClearToMark();
    }
}
