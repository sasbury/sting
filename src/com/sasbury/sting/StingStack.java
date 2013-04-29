package com.sasbury.sting;

import com.sasbury.util.collections.*;

import java.util.*;

public class StingStack implements Cloneable
{
    protected IntArray marks;

    public static final int BUFFER_CHUNK_COUNT = 3;
    public static final int ARRAY_GROWTH_RATE = 2;
    private int size;
    private int used;
    private StingData[] data;

    public StingStack()
    {
        this(5);
    }

    public StingStack(int numSlots)
    {
        used = 0;
        size = numSlots;

        data = new StingData[numSlots];
    }

    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof StingStack)) return false;

        final StingStack stingStack = (StingStack) o;

        if(used != stingStack.used) return false;

        for(int i=0;i<used;i++)
        {
            if(!(data[i].equals(stingStack.data[i]))) return false;
        }

        if(marks != null ? !marks.equals(stingStack.marks) : (stingStack.marks != null && stingStack.marks.size()>0)) return false;

        return true;
    }

    public int hashCode()
    {
        int result;
        result = (marks != null ? marks.hashCode() : 0);
        result = 29 * result + size;
        result = 29 * result + used;
        return result;
    }

    public void trimToFit()
    {
        StingData[] newdata = new StingData[used];
        System.arraycopy(data,0,newdata,0,used);
        size = used;
        data = newdata;
    }

    public void takeValuesFrom(StingStack other)
    {
        insureCapacity(other.used);
        used = other.used;
        System.arraycopy(other.data,0,data,0,used);
    }

    public int getCapacity()
    {
        return size;
    }

    public void insureCapacity(int numSlots)
    {
        if(numSlots > size)
        {
            size = numSlots;
            StingData[] newData = new StingData[numSlots];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    public int size()
    {
        return used;
    }

    public void clear()
    {
        used = 0;
    }

    public StingData get(int index)
    {
        StingData returnValue = null;

        if(index < used) returnValue = data[index];

        return returnValue;
    }

    public void add(StingData value)
    {
        if(used<size)
        {
            data[used] = value;
            used++;
        }
        else
        {
            insert(used, value);
        }
    }

    public void insert(int index, StingData value)
    {
        int i;

        if(index <= used)
        {
            used++;

            if(used >= size)
            {
                insureCapacity(used * ARRAY_GROWTH_RATE);
            }

            for(i = (used - 1); i > index; i--)
            {
                data[i] = data[i - 1];
            }

            data[i] = value;
        }
    }

    public StingData remove(int index)
    {
        StingData returnValue = null;
        int i;

        if(index < used)
        {
            returnValue = data[index];

            for(i = index; i < used - 1; i++)
            {
                data[i] = data[i + 1];
            }

            used--;
        }

        return returnValue;
    }

    public StingData peek()
    {
        int len = size();

        if(len == 0) return null;
        else return get(len - 1);
    }

    public StingData pop(StingData def)
    {
        StingData retVal = def;
        if(used>0)
        {
            used--;
            retVal = data[used];
        }

        return retVal;
    }

    public StingData pop()
    {
        StingData retVal = null;
        if(used>0)
        {
            used--;
            retVal = data[used];
        }
        return retVal;
    }

    public void push(StingData i)
    {
        if(used<size)
        {
            data[used] = i;
            used++;
        }
        else
        {
            insert(used, i);
        }
    }

    public void set(int index,StingData value)
    {
        if(index < used) data[index] = value;
        else insert(index,value);
    }

    public void append(StingData[] array)
    {
        insureCapacity(used+array.length);
        System.arraycopy(array,0,data,used,array.length);
        used += array.length;
    }

    public void append(StingStack other)
    {
        insureCapacity(used+other.used);
        System.arraycopy(other.data,0,data,used,other.used);
        used += other.used;
    }

    public StingData[] toArray()
    {
        StingData[] retVal = new StingData[used];
        System.arraycopy(data,0,retVal,0,used);
        return retVal;
    }

    public void reverse()
    {
        for (int i=0, mid=used>>1, j=used-1; i<mid; i++, j--)
        {
            StingData d1 = data[i];
            StingData d2 = data[j];

            data[j] = d1;
            data[i] = d2;
        }
    }

    public Object clone()
    {
        StingStack retVal = new StingStack();
        retVal.takeValuesFrom(this);
        retVal.marks = (IntArray)marks.clone();
        return retVal;
    }

    /**
     * Tests if this stack is empty.
     *
     * @return <code>true</code> if and only if this stack contains
     *         no items; <code>false</code> otherwise.
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }

    public void mark()
    {
        if(marks == null) marks = new IntArray();
        marks.push(size());
    }

    public void clearMark()
    {
        if(marks != null) marks.pop();
    }

    public StingData[] popToMark()
    {
        ArrayList result = new ArrayList();

        if(marks!=null)
        {
            int mark = marks.pop();

            for(int i=mark,max=size();i>=0 && i<max;i++)
            {
                result.add(pop());
            }

            Collections.reverse(result);
        }

        return (StingData[])result.toArray(new StingData[0]);
    }
}
