package com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Copy implements StingOperation,StingConstants
{
    public String toString()
    {
        return COPY;
    }

    public StingOperation copy()
    {
        return new Copy();
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
            int n = (int)Math.floor(((StingNumber)(stack.pop())).getValue());
            StingData[] toCopy = new StingData[n];
            StingData[] copies = new StingData[n];
            int newIndex;

            for(int i=n-1;i>=0;i--)
            {
                toCopy[i] = stack.pop();
            }

            for(int i=0;i<n;i++)
            {
                copies[i] = toCopy[i].copy();
            }

            for(int i=0;i<n;i++)
            {
                stack.push(toCopy[i]);
            }

            for(int i=0;i<n;i++)
            {
                stack.push(copies[i]);
            }

            retVal = true;
        }

        return retVal;
    }
}
