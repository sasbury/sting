package com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class PI implements StingOperation,StingConstants
{
    public String toString()
    {
        return PI;
    }

    public StingOperation copy()
    {
        return new PI();
    }

    /**
     * Execute the operation, returning true if successfull, false otherwise
     *
     * @param context
     * @return
     */
    public boolean execute(ExecutionContext context)
    {
        boolean retVal = false;
        StingStack stack= context.getStack();

        stack.push(new StingNumber(Math.PI));
        retVal = true;

        return retVal;
    }
}
