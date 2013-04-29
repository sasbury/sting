package com.sasbury.sting.operations.impl;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class PushArray implements StingOperation
{
    protected StingArray value;

    public PushArray(StingArray value)
    {
        this.value = value;
    }

    public PushArray()
    {
    }

    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof PushArray)) return false;

        final PushArray pushArray = (PushArray) o;

        if(value != null ? !value.equals(pushArray.value) : pushArray.value != null) return false;

        return true;
    }

    public int hashCode()
    {
        return (value != null ? value.hashCode() : 0);
    }

    public StingArray getValue()
    {
        return value;
    }

    public void setValue(StingArray value)
    {
        this.value = value;
    }

    public StingOperation copy()
    {
        return new PushArray((StingArray)value.clone());
    }

    /**
     * Execute the operation, returning true if successfull, false otherwise
     *
     * @param context
     * @return
     */
    public boolean execute(ExecutionContext context)
    {
        context.getStack().push((StingArray)value.clone());
        return true;
    }

    public String toString()
    {
        return (value==null)? START_ARRAY+END_ARRAY:value.toString();
    }
}
