package com.sasbury.sting.operations;

import com.sasbury.sting.*;

public class Pop implements StingOperation,StingConstants
{
    public String toString()
    {
        return POP;
    }

    public StingOperation copy()
    {
        return new Pop();
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
            stack.pop();
            retVal = true;
        }

        return retVal;
    }
}
