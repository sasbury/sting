package com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Exp implements StingOperation,StingConstants
{
    public String toString()
    {
        return EXP;
    }

    public StingOperation copy()
    {
        return new Exp();
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
            stack.push(new StingNumber(Math.exp(num.getValue())));
            retVal = true;
        }

        return retVal;
    }
}
