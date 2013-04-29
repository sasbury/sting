package com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class ASin implements StingOperation,StingConstants
{
    public String toString()
    {
        return ASIN;
    }

    public StingOperation copy()
    {
        return new ASin();
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
            double val = num.getValue();

            if(val<0 || val>1) stack.push(num);
            else stack.push(new StingNumber(Math.asin(num.getValue())));
            retVal = true;
        }

        return retVal;
    }
}
