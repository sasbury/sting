package com.sasbury.sting.types;

import com.sasbury.sting.*;

public class StingNull implements StingData,StingConstants
{
    public boolean equals(Object obj)
    {
        return obj instanceof StingNull;
    }

    public int hashCode()
    {
        return NULL.hashCode();
    }

    public StingData copy()
    {
        return new StingNull();
    }

    public String toString()
    {
        return NULL;
    }
}
