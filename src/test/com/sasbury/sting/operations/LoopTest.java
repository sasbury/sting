package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import junit.framework.*;

public class LoopTest extends TestCase
{
	public LoopTest(String name)
	{
		super(name);
	}
	
    public void testOperation() throws Exception
    {
        String program = "5 6 {0 0 4 {index plus} loop} loop plus";

        StingProgram sprogram = new StingProgram(program);
        ExecutionContext context = sprogram.execute();
        StingStack correct = new StingStack();
        correct.push(new StingNumber(20));
        assertTrue(correct.equals(context.getStack()));
    }
}
