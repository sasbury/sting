package com.sasbury.sting.operations;

import com.sasbury.sting.*;

public class Dup implements StingOperation,StingConstants
{
    public String toString()
    {
        return DUP;
    }

    public StingOperation copy()
    {
        return new Dup();
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
            StingData data = stack.peek();
            stack.push(data.copy());
            retVal = true;
        }

        return retVal;
    }
}
