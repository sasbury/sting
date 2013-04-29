package com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import com.sasbury.util.collections.*;

public class ForAll implements StingOperation,StingConstants
{
    public String toString()
    {
        return FORALL ;
    }

    public StingOperation copy()
    {
        return new ForAll();
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
            Indexable array = (Indexable) stack.pop();

            IntArray code = new IntArray();
            code.takeValuesFrom(proc.getCode());

            ForAllContext loopContext = new ForAllContext(context,code,array);
            context.pushContext(loopContext);

            retVal = true;
        }

        return retVal;
    }
}

class ForAllContext extends ExecutionContext
{
    protected int curIndex;
    protected Indexable indexable;

    public ForAllContext(ExecutionContext parent, IntArray code,Indexable array)
    {
        super(parent, code);
        this.indexable = array;
        curIndex = -1;
    }

    public void prepareForExecution()
    {
        IntArray stack = super.getExecutionStack();

        if(stack.size()==0)
        {
            do
            {
                curIndex++;
            }
            while(curIndex<indexable.size() && indexable.getData(new StingNumber(curIndex))==null);

            if(curIndex<indexable.size())
            {
                setLoopIndex(curIndex);
                getStack().push(indexable.getData(new StingNumber(curIndex)));
                prepareExecutionStack();
            }
        }
        else if(curIndex==-1)//first time
        {
            do
            {
                curIndex++;
            }
            while(curIndex<indexable.size() && indexable.getData(new StingNumber(curIndex))==null);
            
            if(curIndex<indexable.size())
            {
                setLoopIndex(curIndex);
                getStack().push(indexable.getData(new StingNumber(curIndex)));
            }
        }
    }
}