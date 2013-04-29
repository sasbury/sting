package com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class Null implements StingOperation
{
    public String toString()
    {
        return NULL ;
    }

    public StingOperation copy()
    {
        return new Null();
    }

    /**
     * Execute the operation, returning true if successfull, false otherwise
     *
     * @param context
     * @return
     */
    public boolean execute(ExecutionContext context)
    {
        context.getStack().push(new StingNull());
        return true;
    }

}
