package com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Cos implements StingOperation,StingConstants
{
    public String toString()
    {
        return COS;
    }

    public StingOperation copy()
    {
        return new Cos();
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

        if(stack.size()>0)
        {
            com.sasbury.sting.types.StingNumber num = (StingNumber) stack.pop();
            stack.push(new StingNumber(Math.cos(num.getValue())));
            retVal = true;
        }

        return retVal;
    }
}
