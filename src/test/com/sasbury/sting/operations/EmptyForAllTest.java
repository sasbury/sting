package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import junit.framework.*;

public class EmptyForAllTest extends TestCase
{
	public EmptyForAllTest(String name)
	{
		super(name);
	}
	
    public void testOperation() throws Exception
    {
        StingProgram program = new StingProgram("[] {} forall");
        ExecutionContext context = program.execute();
        StingStack correct = new StingStack();
        assertTrue(correct.equals(context.getStack()));
    }
}
