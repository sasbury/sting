package com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Size implements StingOperation,StingConstants
{
    public String toString()
    {
        return SIZE ;
    }

    public StingOperation copy()
    {
        return new Size();
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
            Indexable mem = (Indexable)stack.pop();
            stack.push(new StingNumber(mem.size()));
            retVal = true;
        }

        return retVal;
    }
}
