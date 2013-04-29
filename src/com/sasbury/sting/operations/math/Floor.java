package com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Floor implements StingOperation,StingConstants
{
    public String toString()
    {
        return FLOOR;
    }

    public StingOperation copy()
    {
        return new Floor();
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
            StingNumber num = (StingNumber) stack.pop();
            stack.push(new StingNumber((double)Math.floor(num.getValue())));
            retVal = true;
        }

        return retVal;
    }
}

