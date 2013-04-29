package com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;


public class Roll implements StingOperation,StingConstants
{
    public String toString()
    {
        return ROLL;
    }

    public StingOperation copy()
    {
        return new Roll();
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
            int distance = (int)Math.floor(((StingNumber)(stack.pop())).getValue());
            int n = (int)Math.floor(((StingNumber)(stack.pop())).getValue());
            StingData[] toRoll = new StingData[n];
            StingData[] afterRoll = new StingData[n];
            int newIndex;

            for(int i=n-1;i>=0;i--)
            {
                toRoll[i] = stack.pop();
            }

            for(int i=0;i<n;i++)
            {
                newIndex=i+distance;

                if(newIndex<0) newIndex+=n;
                else if(newIndex>=n) newIndex-=n;

                afterRoll[newIndex] = toRoll[i];
            }

            for(int i=0;i<n;i++)
            {
                stack.push(afterRoll[i]);
            }

            retVal = true;
        }

        return retVal;
    }
}
