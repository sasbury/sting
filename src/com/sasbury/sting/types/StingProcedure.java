package com.sasbury.sting.types;

import com.sasbury.sting.*;
import com.sasbury.util.collections.*;

public class StingProcedure implements StingData
{
    protected IntArray code;

    public StingProcedure(IntArray code)
    {
        this.code = code;
    }

    public IntArray getCode()
    {
        return code;
    }

    public void setCode(IntArray code)
    {
        this.code = code;
    }

    public void pushOntoStack(IntArray stack)
    {
        stack.append(code);
    }

    public StingData copy()
    {
        IntArray newCode=new IntArray();
        newCode.takeValuesFrom(code);
        return new StingProcedure(newCode);
    }

    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof StingProcedure)) return false;

        final StingProcedure stingProcedure = (StingProcedure) o;

        if(code != null ? !code.equals(stingProcedure.code) : stingProcedure.code != null) return false;

        return true;
    }

    public int hashCode()
    {
        return (code != null ? code.hashCode() : 0);
    }
}
