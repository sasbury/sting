package com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Pow implements StingOperation,StingConstants
{
    public String toString()
    {
        return POW ;
    }

    public StingOperation copy()
    {
        return new Pow();
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
            double val = Math.pow(one.getValue(),two.getValue());
            if(Double.isNaN(val)) val = 0;
            stack.push(new StingNumber(val));
            retVal = true;
        }

        return retVal;
    }
}
