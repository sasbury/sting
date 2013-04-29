package test.com.sasbury.sting.operations.math;

import test.com.sasbury.sting.operations.*;

public class MaxTest extends ArithmeticTest
{
	public MaxTest(String name)
	{
		super(name);
	}
	
    public double combine(double one, double two)
    {
        return Math.max(one,two);
    }

    public String getOperationName()
    {
        return MAX;
    }
}
