package com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Read implements StingOperation,StingConstants
{
    public String toString()
    {
        return READ ;
    }

    public StingOperation copy()
    {
        return new Read();
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
            StingData holder = stack.pop();
            StingNumber index = (StingNumber)stack.pop();

            if(holder instanceof Indexable)
            {
                Indexable indexable = (Indexable)holder;
                StingData toPush = indexable.getData(index);
                if(toPush!=null) stack.push(toPush);
                retVal = true;
            }
        }

        return retVal;
    }
}
