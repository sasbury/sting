package com.sasbury.util.collections;

import java.util.*;

public class IntArray implements Cloneable
{
    public static final int ARRAY_GROWTH_RATE = 2;

    private int size;
    private int used;
    private int[] data;

    public IntArray()
    {
        this(5);
    }

    public IntArray(int numSlots)
    {
        used = 0;
        size = numSlots;

        data = new int[numSlots];
    }

    public IntArray(int[] ints)
    {
        used = ints.length;
        size = ints.length;
        data = new int[size];
        System.arraycopy(ints,0,data,used,ints.length);
    }

    public Object clone()
    {
        IntArray retVal = new IntArray(used);
        retVal.takeValuesFrom(this);
        return retVal;
    }

    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o instanceof int[])
        {
            boolean retVal = true;
            int[] other = (int[])o;

            for(int i=0,max=used;i<max;i++)
            {
                if((other.length<=i)||(other[i]!=data[i]))
                {
                    retVal=false;
                    break;
                }
            }

            return retVal;
        }

        if(!(o instanceof IntArray)) return false;

        final IntArray intArray = (IntArray) o;

        if(used != intArray.used) return false;
        
        for(int i=0;i<used;i++)
        {
            if(data[i]!=(intArray.data[i])) return false;
        }

        return true;
    }

    public int hashCode()
    {
        int result;
        result = size;
        result = 29 * result + used;
        return result;
    }

    public void trimToFit()
    {
        int[] newdata = new int[used];
        System.arraycopy(data,0,newdata,0,used);
        size = used;
        data = newdata;
    }

    public void takeValuesFrom(IntArray other)
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
            int[] newData = new int[numSlots];
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

    public int get(int index)
    {
        int returnValue = -1;

        if(index < used) returnValue = data[index];

        return returnValue;
    }

    public void add(int value)
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

    public void insert(int index, int value)
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

    public int remove(int index)
    {
        int returnValue = -1;
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

    public int peek()
    {
        if(used == 0) throw new EmptyStackException();

        return data[used - 1];
    }

    public int pop(int def)
    {
        int retVal = def;
        
        if(used>0)
        {
            used--;
            retVal = data[used];
        }

        return retVal;
    }

    public int pop()
    {
        int retVal = -1;
        if(used>0)
        {
            used--;
            retVal = data[used];
        }
        return retVal;
    }

    public void push(int i)
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

    public void set(int index,int value)
    {
        if(index < used) data[index] = value;
        else insert(index,value);
    }

    public void append(int[] array)
    {
        insureCapacity(used+array.length);
        System.arraycopy(array,0,data,used,array.length);
        used += array.length;
    }

    public void append(int[] array,int offset,int length)
    {
        insureCapacity(used+length);
        System.arraycopy(array,offset,data,used,length);
        used += length;
    }

    public void appendReversed(int[] array)
    {
        insureCapacity(used+array.length);
        for(int i=array.length-1;i>=0;i--)
        {
            data[used] = array[i];
            used++;
        }
    }

    public void append(IntArray other)
    {
        insureCapacity(used+other.used);
        System.arraycopy(other.data,0,data,used,other.used);
        used += other.used;
    }

    public void append(IntArray other,int offset,int length)
    {
        insureCapacity(used+length);
        System.arraycopy(other.data,offset,data,used,length);
        used += length;
    }

    public void appendReversed(IntArray array)
    {
        if(array==null || array.size()==0) return;
        
        insureCapacity(used+array.size());

        int[] other = array.data;

        for(int i=array.size()-1;i>=0;i--)
        {
            data[used] = other[i];
            used++;
        }
    }

    public int[] toArray()
    {
        int[] retVal = new int[used];
        System.arraycopy(data,0,retVal,0,used);
        return retVal;
    }

    public void reverse()
    {
        for (int i=0, mid=used>>1, j=used-1; i<mid; i++, j--)
        {
            int d1 = data[i];
            int d2 = data[j];

            data[j] = d1;
            data[i] = d2;
        }
    }
    
    public void sort()
    {
        int[] tt = toArray();
        
        Arrays.sort(tt);
        
        clear();
        append(tt);
    }
}
