package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import junit.framework.*;

public class SimpleExecTest extends TestCase
{
	public SimpleExecTest(String name)
	{
		super(name);
	}
	
    public void testOperation() throws Exception
    {
        String program = "{4 1 plus} exec";

        StingProgram sprogram = new StingProgram(program);
        ExecutionContext context = sprogram.execute();
        StingStack correct = new StingStack();
        correct.push(new StingNumber(5));
        assertTrue(correct.equals(context.getStack()));
    }
}
