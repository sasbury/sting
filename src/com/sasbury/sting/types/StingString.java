package com.sasbury.sting.types;

import com.sasbury.sting.*;
import com.sasbury.util.*;

public class StingString implements Cloneable,StingData,Indexable
{
    protected String value;

    public StingString()
    {
        this.value = null;//the default
    }

    public StingString(String value)
    {
        this.value = value;
    }

    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof StingString)) return false;

        final StingString stingString = (StingString) o;

        if (value != null ? !value.equals(stingString.value) : stingString.value != null) return false;

        return true;
    }

    public int hashCode()
    {
        return (value != null ? value.hashCode() : 0);
    }

    public String toString()
    {
        return '\"'+StringUtilities.escape(value)+'\"';
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public Object clone()
    {
        return new StingString(value);
    }

    public StingData copy()
    {
        return new StingString(value);
    }

    public StingData add(StingData element)
    {
        String str =(element instanceof StingString) ? ((StingString)element).getValue():element.toString();

        if(value == null) value = str;
        else value += str;
        return element;
    }

    public StingData clear(StingNumber index)
    {
        if(value==null || value.length()==0) return null;

        int i= (int) Math.floor(Math.abs(index.getValue()))%value.length();
        String temp = value.substring(0,i);
        String old = ""+value.charAt(i);
        if(i<value.length()) temp += value.substring(i+1,value.length());
        value = temp;
        return new StingString(old);
    }

    public StingData getData(StingNumber index)
    {
        if(value==null || value.length()==0) return null;

        int i= (int) Math.floor(Math.abs(index.getValue()))%value.length();
        String old = ""+value.charAt(i);
        return new StingString(old);
    }

    public StingData setData(StingNumber index, StingData element)
    {
        if(value == null)
        {
            value =(element instanceof StingString) ? ((StingString)element).getValue():element.toString();
            return null;
        }

        int i= (int) Math.floor(Math.abs(index.getValue()))%value.length();
        String temp = value.substring(0,i);
        String old = ""+value.charAt(i);
        temp+=(element instanceof StingString) ? ((StingString)element).getValue():element.toString();
        if(i<value.length()) temp += value.substring(i+1,value.length());
        value = temp;
        return new StingString(old);
    }

    public int size()
    {
        return (value==null)?0:value.length();
    }
}
