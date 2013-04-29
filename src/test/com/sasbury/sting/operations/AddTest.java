package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import junit.framework.*;

public class AddTest extends TestCase
{
	public AddTest(String name)
	{
		super(name);
	}
	
    public void testOperation() throws Exception
    {
        StingProgram program = new StingProgram("5.5 working add working size 1 minus working read");
        ExecutionContext context = program.execute();
        StingStack correct = new StingStack();
        correct.push(new StingNumber(5.5));
        assertTrue(correct.equals(context.getStack()));
    }
}
