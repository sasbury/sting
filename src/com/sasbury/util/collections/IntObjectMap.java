package com.sasbury.util.collections;

import com.sasbury.util.*;

import java.util.*;

public class IntObjectMap
{
    public static final int DEF_CAPACITY = 3;
    public static final float GROW_PERCENTAGE = 0.75f;
    public static final int GROWTH_RATE = 2;

    protected IntObjectNode[] hashtable;
    protected int size;//use size -1 for % in hashing functions
    protected int used;
    private boolean nullOnNegative;

    public IntObjectMap(int numItems)
    {
        int newS;

        newS = (numItems <= 0) ? DEF_CAPACITY:NumberUtils.ceilPrime(numItems);

        hashtable = new IntObjectNode[newS];
        size = newS;
        used = 0;
    }

    public boolean isNullOnNegative()
    {
        return nullOnNegative;
    }

    public void setNullOnNegative(boolean nullOnNegative)
    {
        this.nullOnNegative = nullOnNegative;
    }

    public void clear()
    {
        for(int i=0;i<size;i++)
        {
            hashtable[i]=null;
        }
        used = 0;
    }

    public int size()
    {
        return used;
    }

    public boolean containsKey(int c)
    {
        return get(c) != null;
    }

    public Object remove(int c)
    {
        Object returnValue = null;

        if(used > 0)
        {
            int index;
            IntObjectNode node = null;
            IntObjectNode prev = null;

            index = c % (size - 1);
            node = hashtable[index];

            if(node != null)
            {
                do
                {
                    if(c == node.key)
                    {
                        returnValue = node.value;

                        if(prev==null)
                        {
                            hashtable[index] = node.next;
                        }
                        else
                        {
                            prev.next = node.next;
                        }
                        break;
                    }
                    else
                    {
                        prev = node;
                        node = node.next;
                    }

                } while(node != null);
            }
        }
        return returnValue;
    }

    public Object get(int c)
    {
        Object returnValue = null;

        if(used > 0)
        {
            int index;
            IntObjectNode node = null;

            index = c % (size - 1);
            node = hashtable[index];

            if(node != null)
            {
                do
                {
                    if(c == node.key)
                    {
                        returnValue = node.value;
                        break;
                    }
                    else
                    {
                        node = node.next;
                    }

                } while(node != null);
            }
        }
        return returnValue;
    }

    public Object put(int c, Object val)
    {
        int index;
        IntObjectNode node = null;
        Object valueToReturn = null;
        boolean gotIt = false;

        index = c % (size - 1);
        node = hashtable[index];

        if(node != null)
        {
            do
            {
                if(node.key == c)
                {
                    valueToReturn = node.value;//cache the old one and
                    node.value = val;//replace it
                    gotIt = true;
                    break;
                }
                else
                {
                    node = node.next;
                }

            } while(node != null);
        }

        if(!gotIt)
        {

            node = new IntObjectNode();

            node.key = c;
            node.value = val;
            node.next = hashtable[index];

            hashtable[index] = node;

            used++;

            //check if we need to grow
            if(used >= (GROW_PERCENTAGE * size))
            {
                IntObjectNode[] newTable;
                int newS = GROWTH_RATE * size, newUsed = 0;
                IntObjectIterator iterator = new IntObjectIterator(hashtable, size);
                IntObjectNode newNode = null;
                IntObjectNode nextNode = null;
                int curIndex, i;

                newS = NumberUtils.ceilPrime(newS);

                newTable = new IntObjectNode[newS];

                while(iterator.nextState())
                {
                    curIndex = iterator.key() % (newS - 1);

                    newNode = new IntObjectNode();

                    newNode.key = iterator.key();
                    newNode.value = iterator.value();
                    newNode.next = newTable[curIndex];
                    newTable[curIndex] = newNode;

                    newUsed++;
                }

                for(i = 0; i < size; i++)
                {
                    newNode = hashtable[i];

                    while(newNode != null)
                    {

                        nextNode = newNode.next;
                        newNode = nextNode;

                    }

                    hashtable[i] = null;
                }

                hashtable = newTable;
                size = newS;
                used = newUsed;
            }
        }
        return valueToReturn;
    }

    public Iterator nodes()
    {
        return new IntObjectIterator(hashtable, size);
    }

    public void setByte(int key, byte i)
    {
        if(nullOnNegative && i<0) remove(key);
        else put(key, new Byte(i));
    }

    public byte getByte(int key)
    {
        Object test = get(key);
        byte retVal = (byte)((nullOnNegative)?-1:0);

        if(test instanceof Byte) retVal = ((Byte) test).byteValue();

        return retVal;
    }

    public void setShort(int key, short i)
    {
        if(nullOnNegative && i<0) remove(key);
        else put(key, new Short(i));
    }

    public short getShort(int key)
    {
        Object test = get(key);
        short retVal =(short)((nullOnNegative)?-1:0);

        if(test instanceof Short) retVal = ((Short) test).shortValue();

        return retVal;
    }

    public void setInt(int key, int i)
    {
        if(nullOnNegative && i<0) remove(key);
        else put(key, new Integer(i));
    }

    public int getInt(int key)
    {
        Object test = get(key);
        int retVal = (nullOnNegative)?-1:0;

        if(test instanceof Integer) retVal = ((Integer) test).intValue();

        return retVal;
    }

    public void setLong(int key, long i)
    {
        if(nullOnNegative && i<0) remove(key);
        else put(key, new Long(i));
    }

    public long getLong(int key)
    {
        Object test = get(key);
        long retVal = (nullOnNegative)?-1:0;

        if(test instanceof Long) retVal = ((Long) test).longValue();

        return retVal;
    }

    public void setFloat(int key, float i)
    {
        if(nullOnNegative && i<0) remove(key);
        else put(key, new Float(i));
    }

    public float getFloat(int key)
    {
        Object test = get(key);
        float retVal = (nullOnNegative)?-1:0;

        if(test instanceof Float) retVal = ((Float) test).floatValue();

        return retVal;
    }

    public void setDouble(int key, double i)
    {
        if(nullOnNegative && i<0) remove(key);
        else put(key, new Double(i));
    }

    public double getDouble(int key)
    {
        Object test = get(key);
        double retVal = (nullOnNegative)?-1:0;

        if(test instanceof Double) retVal = ((Double) test).doubleValue();

        return retVal;
    }

    public void setBoolean(int key, boolean i)
    {
        put(key, new Boolean(i));
    }

    public boolean getBoolean(int key)
    {
        Object test = get(key);
        boolean retVal = false;

        if(test instanceof Boolean) retVal = ((Boolean) test).booleanValue();

        return retVal;
    }

    public void setChar(int key, char i)
    {
        put(key, new Character(i));
    }

    public char getChar(int key)
    {
        Object test = get(key);
        char retVal = '\0';

        if(test instanceof Character) retVal = ((Character) test).charValue();

        return retVal;
    }

    public void setString(int key, String string)
    {
        put(key, string);
    }

    public String getString(int key)
    {
        Object test = get(key);
        String retVal = null;

        if(test instanceof String) retVal = ((String) test);

        return retVal;
    }
}

class IntObjectIterator implements Iterator
{
    int curIndex;
    IntObjectNode curNode;
    boolean bumpedCurNode;
    IntObjectNode[] table;
    int tableSize;

    IntObjectIterator(IntObjectNode[] aTable, int aSize)
    {

        table = aTable;
        tableSize = aSize;
        curIndex = -1;
        curNode = null;
        bumpedCurNode = false;
    }

    /**
     * Returns <tt>true</tt> if the iteration has more elements. (In other
     * words, returns <tt>true</tt> if <tt>next</tt> would return an element
     * rather than throwing an exception.)
     *
     * @return <tt>true</tt> if the iterator has more elements.
     */
    public boolean hasNext()
    {
        boolean foundAnotherNode = false;
        IntObjectNode nextNode;
        int index = curIndex;

        if(curNode != null)
        {
            if(true == bumpedCurNode)
            {
                foundAnotherNode = true;
            }
            else//we have a node, try to find the next one at that slot
            {
                nextNode = curNode.next;

                if(nextNode != null)//found one in this slot
                {
                    foundAnotherNode = true;
                }
                else//move to the next slot
                {
                    index++;
                }
            }
        }

        if(foundAnotherNode == false)
        {
            if(index == -1) index = 0;

            while(index < tableSize)
            {
                nextNode = table[index];

                if(nextNode != null)
                {
                    foundAnotherNode = true;
                    break;
                }
                else
                {
                    index++;
                }
            }
        }

        return foundAnotherNode;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration.
     * @exception NoSuchElementException iteration has no more elements.
     */
    public Object next()
    {
        nextState();
        return curNode;
    }

    /**
     *
     * Removes from the underlying collection the last element returned by the
     * iterator (optional operation).  This method can be called only once per
     * call to <tt>next</tt>.  The behavior of an iterator is unspecified if
     * the underlying collection is modified while the iteration is in
     * progress in any way other than by calling this method.
     *
     * @exception UnsupportedOperationException if the <tt>remove</tt>
     *		  operation is not supported by this Iterator.

     * @exception IllegalStateException if the <tt>next</tt> method has not
     *		  yet been called, or the <tt>remove</tt> method has already
     *		  been called after the last call to the <tt>next</tt>
     *		  method.
     */
    public void remove()
    {
        throw new IllegalStateException();
    }

    boolean nextState()
    {
        boolean foundAnotherNode = false;
        IntObjectNode nextNode;

        if(curNode != null)
        {
            if(true == bumpedCurNode)
            {
                foundAnotherNode = true;
            }
            else//we have a node, try to find the next one at that slot
            {
                nextNode = curNode.next;

                if(nextNode != null)//found one in this slot
                {
                    curNode = nextNode;
                    foundAnotherNode = true;
                }
                else//move to the next slot
                {
                    curIndex++;
                }
            }
        }

        if(foundAnotherNode == false)
        {
            if(curIndex == -1) curIndex = 0;

            while(curIndex < tableSize)
            {
                nextNode = table[curIndex];

                if(nextNode != null)
                {
                    curNode = nextNode;
                    foundAnotherNode = true;
                    break;
                }
                else
                {
                    curIndex++;
                }
            }
        }

        bumpedCurNode = false;

        return foundAnotherNode;
    }

    public int key()
    {
        return (curNode == null) ? 0 : curNode.key;
    }

    public Object value()
    {
        return (curNode == null) ? null : curNode.value;
    }
}

class IntObjectNode implements Map.Entry
{
    IntObjectNode next;
    int key;
    Object value;

    /**
     * Returns the key corresponding to this entry.
     *
     * @return the key corresponding to this entry.
     */
    public Object getKey()
    {
        return new Integer(key);
    }

    /**
     * Returns the value corresponding to this entry.  If the mapping
     * has been removed from the backing map (by the iterator's
     * <tt>remove</tt> operation), the results of this call are undefined.
     *
     * @return the value corresponding to this entry.
     */
    public Object getValue()
    {
        return value;
    }

    /**
     * Replaces the value corresponding to this entry with the specified
     * value (optional operation).  (Writes through to the map.)  The
     * behavior of this call is undefined if the mapping has already been
     * removed from the map (by the iterator's <tt>remove</tt> operation).
     *
     * @param value new value to be stored in this entry.
     * @return old value corresponding to the entry.
     *
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *	      is not supported by the backing map.
     * @throws ClassCastException if the class of the specified value
     * 	      prevents it from being stored in the backing map.
     * @throws    IllegalArgumentException if some aspect of this value
     *	      prevents it from being stored in the backing map.
     * @throws NullPointerException the backing map does not permit
     *	      <tt>null</tt> values, and the specified value is
     *	      <tt>null</tt>.
     */
    public Object setValue(Object value)
    {
        throw new UnsupportedOperationException();
    }
}
