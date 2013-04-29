package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import junit.framework.*;

public class ForAllStringTest extends TestCase
{
    public ForAllStringTest(String name)
    {
        super(name);
    }
    
    public void testOperation() throws Exception
    {
        String program = "\"abc\" {index} forall";

        StingProgram sprogram = new StingProgram(program);
        ExecutionContext context = sprogram.execute();
        StingStack correct = new StingStack();
        correct.push(new StingString("a"));
        correct.push(new StingNumber(0));
        correct.push(new StingString("b"));
        correct.push(new StingNumber(1));
        correct.push(new StingString("c"));
        correct.push(new StingNumber(2));
        assertTrue(correct.equals(context.getStack()));
    }
}
