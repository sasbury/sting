package com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Ceil implements StingOperation,StingConstants
{
    public String toString()
    {
        return CEIL ;
    }

    public StingOperation copy()
    {
        return new Ceil();
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
            stack.push(new StingNumber((double)Math.ceil(num.getValue())));
            retVal = true;
        }

        return retVal;
    }
}
