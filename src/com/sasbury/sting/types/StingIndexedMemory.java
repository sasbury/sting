package com.sasbury.sting.types;

import com.sasbury.sting.*;
import com.sasbury.util.collections.*;

import java.util.*;

public class StingIndexedMemory extends IntObjectMap implements StingData,Indexable
{
    protected boolean readOnly;

    public StingIndexedMemory()
    {
        super(31);
    }

    protected StingIndexedMemory(StingIndexedMemory other)
    {
        this();
        readOnly = other.readOnly;
        Iterator nodes = other.nodes();

        while(nodes.hasNext())
        {
            Map.Entry node = (Map.Entry) nodes.next();
            put(((Integer)node.getKey()).intValue(),node.getValue());
        }
    }

    /**
     * Indexed memory objects are "unique" so copy simply returns itself.
     * @return
     */
    public StingData copy()
    {
        return this;
    }

    public boolean isReadOnly()
    {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly)
    {
        this.readOnly = readOnly;
    }

    public void clear()
    {
        if(!readOnly) super.clear();
    }

    public StingData setData(StingNumber n, StingData val)
    {
        int index = (int)Math.floor(Math.abs(n.getValue()));
        return (readOnly)?null:(StingData)super.put(index, val);
    }

    public StingData setData(int c, StingData val)
    {
        return (readOnly)?null:(StingData)super.put(c, val);
    }

    public StingData removeData(StingNumber n)
    {
        int index = (int)Math.floor(Math.abs(n.getValue()));
        return (StingData)((readOnly)?get(index):super.remove(index));
    }

    public StingData getData(StingNumber n)
    {
        int index = (int)Math.floor(Math.abs(n.getValue()));
        return (StingData)get(index);
    }

    public StingData getData(int n)
    {
        int index = (int)Math.abs(n);
        return (StingData)get(index);
    }

    public StingData add(StingData element)
    {
        return setData(size(),element);
    }

    public StingData clear(StingNumber n)
    {
        int index = (int)Math.floor(Math.abs(n.getValue()));
        return setData(index,null);
    }

    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof StingIndexedMemory)) return false;

        final StingIndexedMemory stingIndexedMemory = (StingIndexedMemory) o;

        if(readOnly != stingIndexedMemory.readOnly) return false;

        return super.equals(o);
    }
}
