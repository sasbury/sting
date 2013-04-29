package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import junit.framework.*;

public class IfGtTest extends TestCase
{
    public IfGtTest(String name)
    {
        super(name);
    }
    
    public void testOperation() throws Exception
    {
        String program = "0 {4 1 plus} {3 3 plus} ifgt 1 {4 1 plus} {3 3 plus} ifgt";

        StingProgram sprogram = new StingProgram(program);
        ExecutionContext context = sprogram.execute();
        StingStack correct = new StingStack();
        correct.push(new StingNumber(6));
        correct.push(new StingNumber(5));
        assertTrue(correct.equals(context.getStack()));
    }
}
