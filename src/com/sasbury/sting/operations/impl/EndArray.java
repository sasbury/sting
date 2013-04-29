package com.sasbury.sting.operations.impl;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

import java.util.*;

public class EndArray implements StingOperation
{
    public String toString()
    {
        return END_ARRAY;
    }

    public boolean execute(ExecutionContext context)
    {
        StingData[] data = context.getStack().popToMark();
        StingArray array = new StingArray();
        array.addAll(Arrays.asList(data));

        context.getStack().push(array);
        context.decrementCurrentDepth();
        return true;
    }

    public StingOperation copy()
    {
        return new EndArray();
    }
}
