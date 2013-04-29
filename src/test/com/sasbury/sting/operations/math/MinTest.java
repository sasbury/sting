package test.com.sasbury.sting.operations.math;
import test.com.sasbury.sting.operations.*;

public class MinTest extends ArithmeticTest
{
	public MinTest(String name)
	{
		super(name);
	}
	
    public double combine(double one, double two)
    {
        return Math.min(one,two);
    }

    public String getOperationName()
    {
        return MIN;
    }
}
