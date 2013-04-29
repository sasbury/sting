package test.com.sasbury.sting;

import com.sasbury.sting.*;
import junit.framework.*;

//todo - test strings, test clear/read/write for arrays
public abstract class OperationTest extends TestCase implements StingConstants
{
    public abstract String getOperationName();
    public abstract String getProgram();
    public abstract StingStack getCorrectStack();

    public OperationTest(String name)
    {
        super(name);
    }
    
    public void testOperation() throws Exception
    {
        StingProgram program = new StingProgram(getProgram());

        ExecutionContext context = program.execute();
        StingStack correct = getCorrectStack();
        assertTrue(correct.equals(context.getStack()));
    }

    public void testOperationBadStack() throws Exception
    {
        StingProgram program = new StingProgram(getOperationName());
        ExecutionContext context = program.execute();
        assertTrue(context.getStack().size()==0);
    }
}
