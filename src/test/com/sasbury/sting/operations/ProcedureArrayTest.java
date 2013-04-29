package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import com.sasbury.util.collections.*;
import junit.framework.*;

public class ProcedureArrayTest extends TestCase implements StingConstants
{
    public ProcedureArrayTest(String name)
    {
        super(name);
    }
    
    public void testOperation() throws Exception
    {
        String program = "[noop [1 2 3] 4 1 0]";

        StingProgram sprogram = new StingProgram(program);
        ExecutionContext context = sprogram.execute();
        StingStack correct = new StingStack();
        StingArray data = new StingArray();

        IntArray code = new IntArray(2);
        int index = StingBuiltinOperations.getIndexFor(START_PROCEDURE_RUN);
        index = StingUtilities.setDepth(index,2);
        code.add(index);
        index = StingBuiltinOperations.getIndexFor(END_PROCEDURE_RUN);
        index = StingUtilities.setDepth(index,2);
        code.add(index);
        StingProcedure noOp = new StingProcedure(code);

        StingArray array = new StingArray();
        array.add(new StingNumber(1));
        array.add(new StingNumber(2));
        array.add(new StingNumber(3));

        data.add(noOp);
        data.add(array);
        data.add(new StingNumber(4));
        data.add(new StingNumber(1));
        data.add(new StingNumber(0));

        correct.push(data);
        assertTrue(correct.equals(context.getStack()));
    }
}
