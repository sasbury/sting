package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import junit.framework.*;

public class SimpleLoopTest extends TestCase
{
	public SimpleLoopTest(String name)
	{
		super(name);
	}
	
    public void testOperation() throws Exception
    {
        String program = "0 0 4 {index plus} loop";

        StingProgram sprogram = new StingProgram(program);
        ExecutionContext context = sprogram.execute();
        StingStack correct = new StingStack();
        correct.push(new StingNumber(10));
        assertTrue(correct.equals(context.getStack()));
    }
}
