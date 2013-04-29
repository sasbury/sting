package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import junit.framework.*;

public class ForAllTest extends TestCase
{
    public ForAllTest(String name)
    {
        super(name);
    }
    
    public void testOperation() throws Exception
    {
        String program = "[1 2 3] {index} forall";

        StingProgram sprogram = new StingProgram(program);
        ExecutionContext context = sprogram.execute();
        StingStack correct = new StingStack();
        correct.push(new StingNumber(1));
        correct.push(new StingNumber(0));
        correct.push(new StingNumber(2));
        correct.push(new StingNumber(1));
        correct.push(new StingNumber(3));
        correct.push(new StingNumber(2));
        assertTrue(correct.equals(context.getStack()));
    }
}
