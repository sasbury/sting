package com.sasbury.sting;

import com.sasbury.util.collections.*;

public class StingProgram
{
    protected IntArray byteCode;
    protected String code;
    protected boolean backupStack;
    protected boolean cloneOnPushStringAndNumber;
    protected IntObjectMap indexToOp;
    protected ObjectIntMap opToIndex;
    protected StingInterpreter interpreter;

    public StingProgram()
    {
        backupStack = true;
        cloneOnPushStringAndNumber = true;
    }

    public StingProgram(String code)
    {
        this();
        setCode(code);
    }

    public StingProgram(IntArray code)
    {
        this();
        setByteCode(code);
    }

    public StingProgram(StingProgram other)
    {
        this();
        takeValuesFrom(other);
    }

    public void takeValuesFrom(StingProgram from)
    {
        backupStack = from.backupStack;
        cloneOnPushStringAndNumber = from.cloneOnPushStringAndNumber;
        indexToOp = from.indexToOp;
        opToIndex= from.opToIndex;

        if(from.byteCode!=null) this.byteCode = (IntArray)from.byteCode.clone();
        if(from.code != null) this.code = from.code;
    }
    
    public int addOperation(String name,StingOperation op)
    {
        if(indexToOp==null)
        {
            opToIndex=new ObjectIntMap(31);
            indexToOp = new IntObjectMap(31);
        }

        int index = indexToOp.size()+StingBuiltinOperations.getOperationCount();
        opToIndex.put(name.toLowerCase(),index);
        indexToOp.put(index,op);

        return index;
    }

    public int getIndexFor(String operationName)
    {
        int retVal = StingBuiltinOperations.getIndexFor(operationName);
        if(retVal<0 && (opToIndex!=null)) retVal = opToIndex.get(operationName.toLowerCase());
        return retVal;
    }

    public StingOperation getOperation(int index)
    {
        StingOperation retVal = StingBuiltinOperations.getOperation(index);

        if(retVal == null && (indexToOp!=null))
        {
            retVal = (StingOperation) indexToOp.get(index);
        }

        return retVal;
    }

    public StingInterpreter getInterpreter()
    {
        if(interpreter==null) interpreter= new StingInterpreter();
        return interpreter;
    }

    public ExecutionContext execute() throws Exception
    {
        getByteCode();//make sure it is compiled
        return getInterpreter().execute(this);
    }

    public ExecutionContext execute(ExecutionContext context) throws Exception
    {
        return getInterpreter().execute(context);
    }

    public IntArray getByteCode()
    {
        if(byteCode==null && code!=null)
        {
            try
            {
                byteCode = StingCompiler.shared().compile(this);
            }
            catch(Exception exp)
            {
                byteCode=new IntArray();
            }
        }

        return byteCode;
    }

    public void setByteCode(IntArray byteCode)
    {
        this.byteCode = byteCode;
        code = null;
    }

    /**
     * clears the compiled code but keeps the strin code.
     */
    public void clearByteCode()
    {
        code=null;
    }

    public String getCode() throws SyntaxException
    {
        if(code==null && byteCode!=null)
        {
            code = StingCompiler.shared().decompile(this,true);
        }
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
        
        byteCode=null;
    }

    /**
     * clears the string code but keeps the compiled code.
     */
    public void clearCode()
    {
        code=null;
    }

    public boolean shouldBackupStack()
    {
        return backupStack;
    }

    /**
     * Turn on whether or not the interpreter should back up the stack before executing operations.
     * This value defaults to true, the safest value, but can be set to false in situations where all
     * of the operations are known to be safe (like pushnumber and pushstring.)
     * @param backupStack
     */
    public void setBackupStack(boolean backupStack)
    {
        this.backupStack = backupStack;
    }

    public boolean shouldCloneOnPushStringAndNumber()
    {
        return cloneOnPushStringAndNumber;
    }

    /**
     * Turns on and off cloning in PushNumber and PushString operations. Defaults to true, but can
     * be set to false for programs that are all static push operations.
     * @param cloneOnPushStringAndNumber
     */
    public void setCloneOnPushStringAndNumber(boolean cloneOnPushStringAndNumber)
    {
        this.cloneOnPushStringAndNumber = cloneOnPushStringAndNumber;
    }
}
