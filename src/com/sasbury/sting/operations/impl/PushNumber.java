package com.sasbury.sting.operations.impl;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class PushNumber implements StingOperation
{
    protected double value;
    protected StingNumber number;

    public PushNumber()
    {
    }

    public PushNumber(double value)
    {
        this.value = value;
    }

    public String toString()
    {
        if(value == (int)value) return String.valueOf((int)value);
        else return String.valueOf(value);
    }

    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof PushNumber)) return false;

        final PushNumber pushNumber = (PushNumber) o;

        if(value != pushNumber.value) return false;

        return true;
    }

    public int hashCode()
    {
        final long temp = value != +0.0d ? Double.doubleToLongBits(value) : 0l;
        return (int) (temp ^ (temp >>> 32));
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        number = null;
        this.value = value;
    }

    public StingOperation copy()
    {
        return new PushNumber(getValue());
    }

    /**
     * Execute the operation, returning true if successfull, false otherwise
     *
     * @param context
     * @return
     */
    public boolean execute(ExecutionContext context)
    {
        if(context.shouldCloneOnPushNumberAndString()) context.getStack().push(new StingNumber(value));
        else
        {
            if(number==null) number = new StingNumber(value);
            context.getStack().push(number);
        }
        return true;
    }
}
