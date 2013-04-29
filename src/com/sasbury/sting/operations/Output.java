package com.sasbury.sting.operations;

import com.sasbury.sting.*;

public class Output implements StingOperation,StingConstants
{
    public String toString()
    {
        return OUTPUT;
    }

    public StingOperation copy()
    {
        return new Output();
    }

    public boolean execute(ExecutionContext context)
    {
        context.getStack().push(context.getOutput());
        return true;
    }
}
