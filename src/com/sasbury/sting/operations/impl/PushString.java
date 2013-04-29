package com.sasbury.sting.operations.impl;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class PushString implements StingOperation
{
    protected StingString value;

    public PushString(StingString value)
    {
        this.value = value;
    }

    public PushString(String value)
    {
        this.value = new StingString(value);
    }

    public PushString()
    {
    }

    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof PushString)) return false;

        final PushString pushString = (PushString) o;

        if (value != null ? !value.equals(pushString.value) : pushString.value != null) return false;

        return true;
    }

    public int hashCode()
    {
        return (value != null ? value.hashCode() : 0);
    }

    public StingString getValue()
    {
        return value;
    }

    public void setValue(StingString value)
    {
        this.value = value;
    }

    public StingOperation copy()
    {
        return new PushString((StingString)value.clone());
    }

    /**
     * Execute the operation, returning true if successfull, false otherwise
     *
     * @param context
     * @return
     */
    public boolean execute(ExecutionContext context)
    {
        if(context.shouldCloneOnPushNumberAndString()) context.getStack().push((StingString)value.clone());
        else context.getStack().push(value);
        return true;
    }

    public String toString()
    {
        return (value==null)? "\"\"":value.toString();
    }
}

