package com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Neg implements StingOperation,StingConstants
{
    public String toString()
    {
        return NEG;
    }

    public StingOperation copy()
    {
        return new Neg();
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
            if(num.getValue()==0) stack.push(new StingNumber(0));
            else stack.push(new StingNumber(-(num.getValue())));
            retVal = true;
        }

        return retVal;
    }
}
