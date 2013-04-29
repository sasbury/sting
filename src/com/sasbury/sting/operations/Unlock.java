package com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Unlock implements StingOperation
{
    public String toString()
    {
        return UNLOCK ;
    }

    public StingOperation copy()
    {
        return new Unlock();
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
            StingIndexedMemory mem = (StingIndexedMemory)stack.pop();
            mem.setReadOnly(false);
            retVal = true;
        }

        return retVal;
    }
}
