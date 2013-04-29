package test.com.sasbury.sting.operations;

import com.sasbury.sting.*;
import com.sasbury.sting.types.*;
import junit.framework.*;

public class NestedArrayTest extends TestCase
{
    public NestedArrayTest(String name)
    {
        super(name);
    }
    
    public void testOperation() throws Exception
    {
        String program = "[[1 2 3] 4 1 0 \"test\" foo]";

        StingProgram sprogram = new StingProgram(program);
        ExecutionContext context = sprogram.execute();
        StingStack correct = new StingStack();
        StingArray data = new StingArray();
        StingArray array = new StingArray();
        array.add(new StingNumber(1));
        array.add(new StingNumber(2));
        array.add(new StingNumber(3));

        data.add(array);
        data.add(new StingNumber(4));
        data.add(new StingNumber(1));
        data.add(new StingNumber(0));
        data.add(new StingString("test"));
        data.add(new StingString("foo"));

        correct.push(data);
        assertTrue(correct.equals(context.getStack()));
    }
}
