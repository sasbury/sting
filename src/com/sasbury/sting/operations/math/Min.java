package com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Min implements StingOperation,StingConstants
{
    public String toString()
    {
        return MIN ;
    }

    public StingOperation copy()
    {
        return new Min();
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

        if(stack.size()>1)
        {
            com.sasbury.sting.types.StingNumber two = (StingNumber) stack.pop();
            StingNumber one = (StingNumber) stack.pop();
            stack.push(new StingNumber(Math.min(one.getValue(),two.getValue())));
            retVal = true;
        }

        return retVal;
    }
}
