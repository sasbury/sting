package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import junit.framework.*;

public class EscapeStringTest extends TestCase
{
	public EscapeStringTest(String name)
	{
		super(name);
	}
	
    public void testOperation() throws Exception
    {
        String program = "\"\\n\\t\\\\\\\"\\\'\"";
        StingProgram sprogram = new StingProgram(program);
        ExecutionContext context = sprogram.execute();
        StingStack correct = new StingStack();
        correct.push(new StingString("\n\t\\\"\'"));
        assertTrue(correct.equals(context.getStack()));
    }
}
