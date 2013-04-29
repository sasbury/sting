package com.sasbury.sting.types;

import com.sasbury.sting.*;

import java.util.*;

public class StingArray extends ArrayList implements StingData,StingConstants,Indexable
{
    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public StingArray()
    {
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.  The <tt>ArrayList</tt> instance has an initial capacity of
     * 110% the size of the specified collection.
     *
     * @param c the collection whose elements are to be placed into this list.
     * @throws NullPointerException if the specified collection is null.
     */
    public StingArray(Collection c)
    {
        super(c);
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list.
     * @throws IllegalArgumentException if the specified initial capacity
     *                                  is negative
     */
    public StingArray(int initialCapacity)
    {
        super(initialCapacity);
    }

    public StingData copy()
    {
        return new StingArray(this);
    }

    public StingData getData(StingNumber index)
    {
        int i= (int) Math.floor(Math.abs(index.getValue()));
        return (StingData)get(i);
    }

    public StingData getData(int index)
    {
        int i= Math.abs(index);
        return (StingData)get(i);
    }

    public StingData setData(StingNumber index, StingData element)
    {
        int i= (int) Math.floor(Math.abs(index.getValue()));
        return (StingData)set(i,element);
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of element to return.
     * @return the element at the specified position in this list.
     * @throws IndexOutOfBoundsException if index is out of range <tt>(index
     *                                   &lt; 0 || index &gt;= size())</tt>.
     */
    public Object get(int index)
    {
        index = index%size();
        return super.get(index);
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index   index of element to replace.
     * @param element element to be stored at the specified position.
     * @return the element previously at the specified position.
     * @throws IndexOutOfBoundsException if index out of range
     *                                   <tt>(index &lt; 0 || index &gt;= size())</tt>.
     */
    public Object set(int index, Object element)
    {
        index = index%size();
        return super.set(index, element);
    }

    public StingData add(StingData element)
    {
        super.add(element);
        return element;
    }

    public StingData clear(StingNumber index)
    {
        int i= (int) Math.floor(Math.abs(index.getValue()))%size();
        return (StingData) super.remove(i);
    }

    public String toString()
    {
        StringBuffer buff = new StringBuffer();

        buff.append(START_ARRAY);

        for(int i=0,max=size();i<max;i++)
        {
            if(i!=0) buff.append(" ");
            buff.append(getData(i).toString());
        }

        buff.append(END_ARRAY);
        return buff.toString();
    }
}
