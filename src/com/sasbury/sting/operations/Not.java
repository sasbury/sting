package com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Not implements StingOperation,StingConstants
{
    public String toString()
    {
        return NOT;
    }

    public StingOperation copy()
    {
        return new Not();
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
            StingNumber one = (StingNumber) stack.pop();
            double toPush = -1;

            if(one.getValue()<=0)
            {
               toPush = 1;
            }

            stack.push(new StingNumber(toPush));

            retVal = true;
        }

        return retVal;
    }
}
