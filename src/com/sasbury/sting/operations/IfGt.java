package com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import com.sasbury.util.collections.*;

public class IfGt implements StingOperation,StingConstants
{
    public String toString()
    {
        return IFGT ;
    }

    public StingOperation copy()
    {
        return new IfGt();
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
            StingProcedure proc2 = (StingProcedure)stack.pop();
            StingProcedure proc1 = (StingProcedure)stack.pop();
            StingNumber test = (StingNumber)stack.pop();
            IntArray code = new IntArray();

            if(test.getValue() > 0)
            {
                code.takeValuesFrom(proc1.getCode());
            }
            else
            {
                code.takeValuesFrom(proc2.getCode());
            }

            context.execute(code);
            retVal = true;
        }

        return retVal;
    }
}
