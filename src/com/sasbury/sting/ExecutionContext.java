package com.sasbury.sting;

import com.sasbury.sting.types.*;
import com.sasbury.util.collections.*;

public class ExecutionContext
{
    protected IntArray executionStack;
    protected int currentDepth;
    protected StingStack stack;
    protected StingStack backupstack;
    protected StingIndexedMemory input;
    protected StingIndexedMemory output;
    protected StingIndexedMemory working;
    protected FastStack arrays;
    protected int loopIndex;
    protected IntArray code;
    protected StingProgram program;


    public ExecutionContext(StingProgram program) throws Exception
    {
        this.program = program;
        this.code = program.getByteCode();

        executionStack = new IntArray(101);
        stack = new StingStack();
        backupstack = new StingStack();
    }

    protected ExecutionContext(ExecutionContext parent,IntArray code)
    {
        this.program = parent.program ;
        this.code = code;

        executionStack = new IntArray(101);
        stack = parent.stack;
        backupstack = parent.backupstack;

        input = parent.input;
        output = parent.output;
        working = parent.working;

        loopIndex= parent.loopIndex;
        currentDepth = parent.currentDepth;
    }
    
    public ExecutionContext createSubContext(IntArray code)
    {
        return new ExecutionContext(this,code);
    }

    /**
     * Locks the input, if it is non-null. Otherwise does nothing.
     */
    public void lockInput()
    {
        if(input != null) input.setReadOnly(true);
    }

    /**
     * Unlocks the input, if it is non-null. Otherwise does nothing.
     */
    public void unlockInput()
    {
        if(input != null) input.setReadOnly(false);
    }

    public StingIndexedMemory getInput()
    {
        if(input == null) input = new StingIndexedMemory();
        return input;
    }

    public StingIndexedMemory getOutput()
    {
        if(output == null) output = new StingIndexedMemory();
        return output;
    }

    /**
     * Default size is 5;
     * @return
     */
    public StingIndexedMemory getWorking()
    {
        if(working == null) working = new StingIndexedMemory();
        return working;
    }

    public IntArray getExecutionStack()
    {
        return executionStack;
    }

    public StingStack getStack()
    {
        return stack;
    }

    public void backupStack()
    {
        backupstack.clear();

        if(stack.size()>0) backupstack.takeValuesFrom(stack);
    }

    public void revertStack()
    {
        StingStack tmp=stack;

        stack = backupstack;
        backupstack = tmp;
    }

    public void commitStack()
    {
        //do nothing
    }

    public int getCurrentDepth()
    {
        return currentDepth;
    }

    public void incrementCurrentDepth()
    {
        currentDepth++;
    }

    public void decrementCurrentDepth()
    {
        currentDepth = Math.max(0,currentDepth-1);
    }

    public int getLoopIndex()
    {
        return loopIndex;
    }

    public void setLoopIndex(int loopIndex)
    {
        this.loopIndex = loopIndex;
    }

    public StingArray getCurrentArray()
    {
        return (StingArray)((arrays!=null && arrays.size()>0)? arrays.peek():null);
    }

    public void endArray()
    {
        if(arrays!=null && arrays.size()>0) arrays.pop();
    }

    public void startArray()
    {
        if(arrays==null) arrays = new FastStack();
        arrays.push(new StingArray());
    }

    public IntArray getCode()
    {
        return code;
    }

    public StingProgram getProgram()
    {
        return program;
    }

    /**
     * Shortcut for creating a subcontext and telling the interpreter to execute it
     * @param code
     */
    public void execute(IntArray code)
    {
        program.getInterpreter().pushContext(createSubContext(code));
    }

    public void pushContext(ExecutionContext context)
    {
        program.getInterpreter().pushContext(context);
    }

    public void prepareExecutionStack()
    {
        getExecutionStack().appendReversed(getCode());
    }

    public void prepareForExecution()
    {
        //for subclasses that loop
    }

    public boolean shouldCloneOnPushNumberAndString()
    {
        return program.shouldCloneOnPushStringAndNumber();
    }
}
