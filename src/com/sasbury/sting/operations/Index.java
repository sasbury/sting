package com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Index implements StingOperation,StingConstants
{
    public String toString()
    {
        return INDEX ;
    }

    public StingOperation copy()
    {
        return new Index();
    }

    public boolean execute(ExecutionContext context)
    {
        context.getStack().push(new StingNumber(context.getLoopIndex()));
        return true;
    }
}
