package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import junit.framework.*;

public class ExecTest extends TestCase
{
    public ExecTest(String name)
    {
        super(name);
    }
    
    public void testOperation() throws Exception
    {
        String program = "{{4 1 plus} exec {3 1 minus} exec plus} exec { 0 } exec";

        StingProgram sprogram = new StingProgram(program);
        ExecutionContext context = sprogram.execute();
        StingStack correct = new StingStack();
        correct.push(new StingNumber(7));
        correct.push(new StingNumber(0));
        assertTrue(correct.equals(context.getStack()));
    }
}
