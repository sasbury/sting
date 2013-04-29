package test.com.sasbury.sting.operations;

import junit.framework.*;
import com.sasbury.sting.*;
import com.sasbury.sting.types.*;

public class NullTest extends TestCase
{
	public NullTest(String name)
	{
		super(name);
	}
	
    public void testOperation() throws Exception
    {
        String program = "input unlock null input add null input add input lock input size";

        StingProgram sprogram = new StingProgram(program);
        ExecutionContext context = sprogram.execute();

        StingStack correct = new StingStack();
        correct.push(new StingNumber(2));
        assertTrue(correct.equals(context.getStack()));
    }
}
