package test.com.sasbury.sting;

import com.sasbury.sting.*;
import junit.framework.*;

public class GarbageProgramTest extends TestCase
{
	public GarbageProgramTest(String name)
	{
		super(name);
	}
	
    public void testGarbageProgram() throws Exception
    {
        StingProgram program = new StingProgram("pop pop dup swap plus minus read");

        ExecutionContext context = program.execute();
        StingStack correct = new StingStack();
        assertTrue(correct.equals(context.getStack()));
    }
}
