package com.sasbury.sting.types;

import com.sasbury.sting.*;

public class StingNumber implements Cloneable,StingData
{
    protected double value;

    public StingNumber()
    {
        this.value = 0;//the default
    }

    public StingNumber(double value)
    {
        this.value = value;
    }

    public StingNumber(String value)
    {
        this.value = Double.parseDouble(value);
    }

    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof StingNumber)) return false;

        final StingNumber stingNumber = (StingNumber) o;

        if(value != stingNumber.value || (Double.isNaN(value) && Double.isNaN(stingNumber.value))) return false;

        return true;
    }

    public int hashCode()
    {
        final long temp = value != +0.0d ? Double.doubleToLongBits(value) : 0l;
        return (int) (temp ^ (temp >>> 32));
    }

    public String toString()
    {
        return String.valueOf(value);
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public Object clone()
    {
        return new StingNumber(value);
    }

    public StingData copy()
    {
        return new StingNumber(value);
    }
}
