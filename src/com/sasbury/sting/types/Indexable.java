package com.sasbury.sting.types;

import com.sasbury.sting.*;

public interface Indexable extends StingData
{
    public StingData getData(StingNumber index);
    public StingData setData(StingNumber index, StingData element);

    public StingData add(StingData element);
    public StingData clear(StingNumber index);
    public int size();
}
