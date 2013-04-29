package com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import com.sasbury.util.collections.*;

public class NoOp implements StingOperation,StingConstants
{
    public String toString()
    {
        return NOOP ;
    }

    public StingOperation copy()
    {
        return new NoOp();
    }

    public boolean execute(ExecutionContext context)
    {
        IntArray code = new IntArray(2);
        int index = StingBuiltinOperations.getIndexFor(START_PROCEDURE_RUN);
        index = StingUtilities.setDepth(index,context.getCurrentDepth()+1);
        code.add(index);
        index = StingBuiltinOperations.getIndexFor(END_PROCEDURE_RUN);
        index = StingUtilities.setDepth(index,context.getCurrentDepth()+1);
        code.add(index);
        StingProcedure noOp = new StingProcedure(code);
        context.getStack().push(noOp);
        return true;
    }
}
