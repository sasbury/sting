package test.com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import test.com.sasbury.sting.operations.*;

public class SqrtTest extends NumberOpTest implements StingConstants
{
	public SqrtTest(String name)
	{
		super(name);
	}
	
    public String getOperationName()
    {
        return SQRT;
    }

    public double operateOn(double one)
    {
        return (one<0)? one: Math.sqrt(one);
    }
}
