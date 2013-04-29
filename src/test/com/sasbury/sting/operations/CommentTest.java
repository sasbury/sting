package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import junit.framework.*;

public class CommentTest extends TestCase
{
    public CommentTest(String name)
    {
        super(name);
    }
    
    public void testOperation() throws Exception
    {
        StingProgram program = new StingProgram("1//2\n3\n//4\n5");
        ExecutionContext context = program.execute();
        StingStack correct = new StingStack();
        correct.push(new StingNumber(1));
        correct.push(new StingNumber(3));
        correct.push(new StingNumber(5));
        assertTrue(correct.equals(context.getStack()));
    }
}
