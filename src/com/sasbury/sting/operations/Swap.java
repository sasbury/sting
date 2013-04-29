package com.sasbury.sting.operations;

import com.sasbury.sting.*;

public class Swap implements StingOperation,StingConstants
{
    public String toString()
    {
        return SWAP;
    }

    public StingOperation copy()
    {
        return new Swap();
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
            StingData two = stack.pop();
            StingData one = stack.pop();

            stack.push(two);
            stack.push(one);
            retVal = true;
        }

        return retVal;
    }
}
