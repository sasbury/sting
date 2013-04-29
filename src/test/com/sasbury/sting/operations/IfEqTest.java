package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import junit.framework.*;

public class IfEqTest extends TestCase
{
    public IfEqTest(String name)
    {
        super(name);
    }
    
    public void testOperation() throws Exception
    {
        String program = "0 {4 1 plus} {3 3 plus} ifeq 1 {4 1 plus} {3 3 plus} ifeq";

        StingProgram sprogram = new StingProgram(program);
        ExecutionContext context = sprogram.execute();
        StingStack correct = new StingStack();
        correct.push(new StingNumber(5));
        correct.push(new StingNumber(6));
        assertTrue(correct.equals(context.getStack()));
    }
}
