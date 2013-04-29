package test.com.sasbury.sting.operations.math;

import test.com.sasbury.sting.operations.*;

public class AbsTest extends NumberOpTest
{
	public AbsTest(String name)
	{
		super(name);
	}
	
    public String getOperationName()
    {
        return ABS;
    }

    public double operateOn(double one)
    {
        return Math.abs(one);
    }
}
