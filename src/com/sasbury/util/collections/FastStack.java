package com.sasbury.util.collections;

import java.util.*;

public class FastStack extends ArrayList
{
    public Object clone()
    {
        FastStack retVal = new FastStack();
        Collections.copy(this,retVal);
        return retVal;
    }

    /**
     * Pushes an item onto the top of this stack. This has exactly
     * the same effect as:
     * <blockquote><pre>
     * addElement(item)</pre></blockquote>
     *
     * @param item the item to be pushed onto this stack.
     * @return the <code>item</code> argument.
     */
    public Object push(Object item)
    {
        add(item);

        return item;
    }

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack (the last item
     *         of the <tt>Vector</tt> object).
     * @throws EmptyStackException if this stack is empty.
     */
    public Object pop()
    {
        int len = size();
        if(len==0) throw new EmptyStackException();
        return remove(len-1);
    }
    
    /**
     * Returns null for an empty stack or the last element for a stack with contents.
     * @return
     */
    public Object safePop()
    {
        Object retVal = null;
        int len = size();
        if(len>0) retVal = remove(len-1);
        return retVal;
    }

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return the object at the top of this stack (the last item
     *         of the <tt>Vector</tt> object).
     * @throws EmptyStackException if this stack is empty.
     */
    public Object peek()
    {
        int len = size();

        if(len == 0) throw new EmptyStackException();

        return get(len - 1);
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

    public void reverse()
    {
        Collections.reverse(this);
    }
}
