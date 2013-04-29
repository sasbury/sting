package com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Add implements StingOperation,StingConstants
{
    public String toString()
    {
        return ADD ;
    }

    public StingOperation copy()
    {
        return new Add();
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
            StingData holder = stack.pop();
            StingData data = stack.pop();

            if(holder instanceof Indexable)
            {
                Indexable indexable = (Indexable)holder;
                indexable.add(data);
                retVal = true;
            }
        }

        return retVal;
    }
}
