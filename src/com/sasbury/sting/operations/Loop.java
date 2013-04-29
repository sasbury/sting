package com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import com.sasbury.util.collections.*;

public class Loop implements StingOperation,StingConstants
{
    public String toString()
    {
        return LOOP ;
    }

    public StingOperation copy()
    {
        return new Loop();
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
            StingNumber to = (StingNumber) stack.pop();
            StingNumber from = (StingNumber) stack.pop();
            int start = (int)Math.floor(from.getValue());
            int end = (int)Math.floor(to.getValue());
            IntArray code = new IntArray();
            code.takeValuesFrom(proc.getCode());

            LoopContext loopContext = new LoopContext(context,code,start,end);
            context.pushContext(loopContext);

            retVal = true;
        }

        return retVal;
    }
}

class LoopContext extends ExecutionContext
{
    protected int curIndex;
    protected int end;
    protected int start;

    public LoopContext(ExecutionContext parent, IntArray code,int start,int max)
    {
        super(parent, code);
        this.end = max;
        this.start = start;
        curIndex = -1;
    }

    public void prepareForExecution()
    {
        IntArray stack = super.getExecutionStack();

        if(stack.size()==0)
        {
            curIndex++;
            if(curIndex<=end)
            {
                setLoopIndex(curIndex);
                prepareExecutionStack();
            }
        }
        else if(curIndex==-1)//first time
        {
            curIndex=start;
            if(curIndex<=end)
            {
                setLoopIndex(curIndex);
            }
            else
            {
                executionStack.clear();
            }
        }
    }
}