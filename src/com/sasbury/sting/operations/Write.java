package com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Write implements StingOperation,StingConstants
{
    public String toString()
    {
        return WRITE ;
    }

    public StingOperation copy()
    {
        return new Write();
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

        if(stack.size()>2)
        {
            StingData holder = stack.pop();
            StingNumber index = (StingNumber)stack.pop();
            StingData data = stack.pop();

            
            if(holder instanceof Indexable)
            {
                Indexable indexable = (Indexable)holder;
                indexable.setData(index,data);
                retVal = true;
            }
        }

        return retVal;
    }
}
