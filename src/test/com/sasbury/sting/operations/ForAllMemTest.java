package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import junit.framework.*;

public class ForAllMemTest extends TestCase
{
    public ForAllMemTest(String name)
    {
        super(name);
    }
    
    public void testOperation() throws Exception
    {
        String program = "5.5 0 working write 4.4 1 working write working {} forall";

        StingProgram sprogram = new StingProgram(program);
        ExecutionContext context = sprogram.execute();
        StingStack correct = new StingStack();
        correct.push(new StingNumber(5.5));
        correct.push(new StingNumber(4.4));
        assertTrue(correct.equals(context.getStack()));
    }
}
