package test.com.sasbury.sting;

import com.sasbury.sting.*;
import junit.framework.*;

public abstract class PushOpTest extends TestCase implements StingConstants
{
    public abstract String getOperationName();
    public abstract StingStack getCorrectStack(ExecutionContext context);

	public PushOpTest(String name)
	{
		super(name);
	}
	
    public void testOperation() throws Exception
    {
        StingProgram program = new StingProgram(getOperationName());
        ExecutionContext context = program.execute();
        StingStack correct = getCorrectStack(context);
        assertTrue(correct.equals(context.getStack()));
    }
}

