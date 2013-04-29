package com.sasbury.sting;

import com.sasbury.sting.operations.impl.*;
import com.sasbury.sting.operations.*;
import com.sasbury.sting.operations.math.*;
import com.sasbury.util.collections.*;

public class StingBuiltinOperations implements StingConstants
{

    protected static IntObjectMap indexToOp;
    protected static ObjectIntMap opToIndex;

    static
    {
        indexToOp = new IntObjectMap(101);
        opToIndex = new ObjectIntMap(101);
        
        addOperation(START_PROCEDURE_RUN,new StartProcedureRun());
        addOperation(END_PROCEDURE_RUN,new EndProcedureRun());
        addOperation(START_PROCEDURE,new StartProcedure());
        addOperation(END_PROCEDURE,new EndProcedure());

        addOperation(START_ARRAY,new StartArray());
        addOperation(END_ARRAY,new EndArray());

        addOperation(DUP,new Dup());
        addOperation(SWAP,new Swap());
        addOperation(POP,new Pop());
        addOperation(ROLL,new Roll());
        addOperation(COPY,new Copy());
        addOperation(CLEAR_TO_MARK,new ClearToMark());
        addOperation(MARK,new Mark());

        addOperation("+",new Plus());
        addOperation(PLUS,new Plus());
        addOperation("-",new Minus());
        addOperation(MINUS,new Minus());
        addOperation("*",new Times());
        addOperation(TIMES,new Times());
        addOperation("/",new Divide());
        addOperation(DIVIDE,new Divide());
        addOperation("%",new Modulo());
        addOperation(MODULO,new Modulo());
        addOperation(FLOOR,new Floor());
        addOperation(CEIL,new Ceil());
        addOperation(NEG,new Neg());
        addOperation(ABS,new Abs());

        addOperation(AND,new And());
        addOperation(OR,new Or());
        addOperation(XOR,new Xor());
        addOperation(NOT,new Not());

        addOperation(INPUT,new Input());
        addOperation(OUTPUT,new Output());
        addOperation(WORKING,new Working());

        addOperation(SIZE,new Size());
        addOperation(READ,new Read());
        addOperation(WRITE,new Write());
        addOperation(ADD,new Add());
        addOperation(CLEAR,new Clear());
        addOperation(LOCK,new Lock());
        addOperation(UNLOCK,new Unlock());
        addOperation(NULL,new Null());

        addOperation(EXEC,new Exec());
        addOperation(NOOP,new NoOp());
        addOperation(SKIP,new Skip());

        addOperation(IFEQ,new IfEq());
        addOperation(IFGT,new IfGt());

        addOperation(LOOP,new Loop());
        addOperation(FORALL ,new ForAll());
        addOperation(INDEX,new Index());

        addOperation(ACOS,new ACos());
        addOperation(ASIN,new ASin());
        addOperation(ATAN,new ATan());
        addOperation(COS,new Cos());
        addOperation(SIN,new Sin());
        addOperation(TAN,new Tan());
        addOperation(MIN,new Min());
        addOperation(MAX,new Max());
        addOperation(EXP,new Exp());
        addOperation(LOG,new Log());
        addOperation(SQRT,new Sqrt());
        addOperation(POW,new Pow());
        addOperation(E,new E());
        addOperation(PI,new PI());
    }

    public static int getOperationCount()
    {
        return opToIndex.size();
    }

    private static void addOperation(String name,StingOperation op)
    {
        int index = indexToOp.size();
        opToIndex.put(name.toLowerCase(),index);
        indexToOp.put(index,op);
    }

    public static int getIndexFor(String operationName)
    {
        return opToIndex.get(operationName.toLowerCase());
    }

    public static StingOperation getOperation(int index)
    {
        return (StingOperation) indexToOp.get(index);
    }

    public static boolean isStart(int operationIndex)
    {
        StingOperation op = getOperation(operationIndex);
        return isStart(op);
    }

    public static boolean isStart(StingOperation op)
    {
        return isLogicalStart(op)||isPhysicalStart(op);
    }

    public static boolean isEnd(int operationIndex)
    {
        StingOperation op = getOperation(operationIndex);
        return isEnd(op);
    }

    public static boolean isEnd(StingOperation op)
    {
        return isLogicalEnd(op)||isPhysicalEnd(op);
    }

    protected static boolean isLogicalStart(StingOperation op)
    {
        return (op instanceof StartProcedure);
    }

    protected static boolean isPhysicalStart(StingOperation op)
    {
        return (op instanceof StartProcedureRun)||(op instanceof StartArray);
    }

    protected static boolean isLogicalEnd(StingOperation op)
    {
        return (op instanceof EndProcedure);
    }

    protected static boolean isPhysicalEnd(StingOperation op)
    {
        return (op instanceof EndProcedureRun)||(op instanceof EndArray);
    }
}
