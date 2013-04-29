package test.com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import test.com.sasbury.sting.operations.*;

public class ExpTest extends NumberOpTest implements StingConstants
{
	public ExpTest(String name)
	{
		super(name);
	}
	
    public String getOperationName()
    {
        return EXP;
    }

    public double operateOn(double one)
    {
        return Math.exp(one);
    }
}
