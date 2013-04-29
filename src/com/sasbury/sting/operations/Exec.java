package com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import com.sasbury.util.collections.*;

public class Exec implements StingOperation,StingConstants
{
    public String toString()
    {
        return EXEC ;
    }

    public StingOperation copy()
    {
        return new Exec();
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
            StingProcedure proc = (StingProcedure)stack.pop();
            IntArray code = new IntArray();
            code.takeValuesFrom(proc.getCode());
            context.execute(code);
            retVal = true;
        }

        return retVal;
    }
}
