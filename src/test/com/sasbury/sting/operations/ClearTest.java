package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import junit.framework.*;

public class ClearTest extends TestCase
{
	public ClearTest(String name)
	{
		super(name);
	}
	
    public void testOperation() throws Exception
    {
        StingProgram program = new StingProgram("5.5 1 working write 4.4 2 working write 1 working clear 2 working clear 1 working read 2 working read");
        ExecutionContext context = program.execute();
        StingStack correct = new StingStack();
        assertTrue(correct.equals(context.getStack()));
    }
}
