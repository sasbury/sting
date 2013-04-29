package com.sasbury.sting;

import com.sasbury.sting.types.*;
import com.sasbury.util.collections.*;

public class StingInterpreter implements StingConstants
{
    protected FastStack contexts;
    protected StingProgram program;

    public ExecutionContext execute(StingProgram program) throws Exception
    {
        this.program = program;
        return execute(new ExecutionContext(program));
    }

    public ExecutionContext execute(ExecutionContext context)
    {
        if(contexts==null) contexts = new FastStack();

        pushContext(context);

        IntArray stack;
        ExecutionContext curContext=null;
        context.lockInput();

        while(contexts.size()>0)
        {
            curContext=(ExecutionContext) contexts.peek();
            curContext.prepareForExecution();
            stack = curContext.getExecutionStack();

            if(stack.size()==0)
            {
                contexts.pop();
            }
            else
            {
                executeOne(curContext);
            }
        }

        context.unlockInput();
        contexts.clear();

        return curContext;
    }

    public void executeOne(ExecutionContext context)
    {
        StingProgram program = context.getProgram();
        IntArray stack = context.getExecutionStack();
        int depth = context.getCurrentDepth();
        int nextCode = stack.peek();
        int nextOpCode=StingUtilities.getOperationIndex(nextCode);

        if(nextCode == -1 || program.getOperation(nextOpCode)==null)
        {
            stack.pop();
            return;
        }
        int nextDepth=StingUtilities.getDepth(nextCode);

        StingOperation nextOp = program.getOperation(nextOpCode);

        if(nextDepth==depth
            || ((nextDepth == depth+1)&&(StingBuiltinOperations.isPhysicalStart(nextOp))))
        {
            nextCode = stack.pop();

            boolean success = false;

            if(program.shouldBackupStack()) context.backupStack();

            try
            {
                success= nextOp.execute(context);
            }
            catch(Exception exp)
            {
                success= false;
                //Application.instance().debug(exp);
            }

            if(program.shouldBackupStack())
            {
                if(success) context.commitStack();
                else context.revertStack();
            }
        }
        else
        {
            IntArray procCode = new IntArray();
            int opIndex,procDepth;

            while(stack.size()>0)
            {
                nextCode = stack.pop();

                opIndex = StingUtilities.getOperationIndex(nextCode);
                procDepth = StingUtilities.getDepth(nextCode);

                if(StingBuiltinOperations.isLogicalEnd(program.getOperation(opIndex)) && depth==(procDepth-1))
                {
                    procCode.add(nextCode);
                    break;
                }
                else
                {
                    procCode.add(nextCode);
                }
            }

            opIndex = procCode.get(0);
            opIndex = StingUtilities.setOperationIndex(opIndex,program.getIndexFor(START_PROCEDURE_RUN));
            procCode.set(0,opIndex);

            int index = procCode.size()-1;
            opIndex = procCode.get(index);
            opIndex = StingUtilities.setOperationIndex(opIndex,program.getIndexFor(END_PROCEDURE_RUN));
            procCode.set(index,opIndex);

            StingProcedure proc = new StingProcedure(procCode);
            context.getStack().push(proc);
        }
    }

    public void pushContext(ExecutionContext context)
    {
        context.prepareExecutionStack();

        contexts.push(context);
    }
}
