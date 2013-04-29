package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import junit.framework.*;

public class NoOpTest extends TestCase
{
	public NoOpTest(String name)
	{
		super(name);
	}
	
    public void testOperation() throws Exception
    {
        String program = "noop exec";

        StingProgram sprogram = new StingProgram(program);
        ExecutionContext context = sprogram.execute();
        StingStack correct = new StingStack();
        assertTrue(correct.equals(context.getStack()));
    }
}
