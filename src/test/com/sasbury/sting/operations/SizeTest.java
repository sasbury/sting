package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import junit.framework.*;

public class SizeTest extends TestCase
{
    public SizeTest(String name)
    {
        super(name);
    }
    
    public void testOperation() throws Exception
    {
        String program = "working size input size output size [1 2 3] size \"foobarblat\" size";

        StingProgram sprogram = new StingProgram(program);

        ExecutionContext context = new ExecutionContext(sprogram);

        context.getWorking().put(0,null);
        context.getWorking().put(1,null);
        context.getWorking().put(2,null);
        context.getWorking().put(3,null);
        context.getWorking().put(4,null);
        
        sprogram.execute(context);

        StingStack correct = new StingStack();
        correct.push(new StingNumber(5));
        correct.push(new StingNumber(0));
        correct.push(new StingNumber(0));
        correct.push(new StingNumber(3));
        correct.push(new StingNumber(10));
        assertTrue(correct.equals(context.getStack()));
    }
}
