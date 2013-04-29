package test.com.sasbury.sting;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import junit.framework.*;

public class WhiteSpaceTest extends TestCase
{
    public WhiteSpaceTest(String name)
    {
        super(name);
    }
    
    public StingStack getCorrectStack()
    {
        StingStack stack = new StingStack();
        stack.push(new StingNumber(1));
        stack.push(new StingNumber(2));
        stack.push(new StingNumber(3));
        stack.push(new StingNumber(4));
        return stack;
    }

    public String getProgram()
    {
        return "1    2\n\n\n3\t\t\t4";
    }

    public void testWhitespace() throws Exception
    {
        StingProgram program = new StingProgram(getProgram());
        ExecutionContext context = program.execute();
        StingStack correct = getCorrectStack();
        assertTrue(correct.equals(context.getStack()));
    }
}
