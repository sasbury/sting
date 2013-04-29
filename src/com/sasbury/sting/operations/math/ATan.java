package com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class ATan implements StingOperation,StingConstants
{
    public String toString()
    {
        return ATAN;
    }

    public StingOperation copy()
    {
        return new ATan();
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
            stack.push(new StingNumber(Math.atan(num.getValue())));
            retVal = true;
        }

        return retVal;
    }
}
