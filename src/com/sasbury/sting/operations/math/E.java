package com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class E implements StingOperation,StingConstants
{
    public String toString()
    {
        return E;
    }

    public StingOperation copy()
    {
        return new E();
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

        stack.push(new StingNumber(Math.E));
        retVal = true;

        return retVal;
    }
}
