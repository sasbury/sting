package com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Log implements StingOperation,StingConstants
{
    public String toString()
    {
        return LOG;
    }

    public StingOperation copy()
    {
        return new Log();
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
            if(num.getValue()<=0) stack.push(num);
            else stack.push(new StingNumber(Math.log(num.getValue())));
            retVal = true;
        }

        return retVal;
    }
}
