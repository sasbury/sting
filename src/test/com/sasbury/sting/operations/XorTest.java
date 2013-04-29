package test.com.sasbury.sting.operations;

public class XorTest extends ArithmeticTest
{
	public XorTest(String name)
	{
		super(name);
	}
	
    public double combine(double one, double two)
    {
        return ((one>0 && two<=0) || (one<=0 && two>0))?1:-1;
    }

    public String getOperationName()
    {
        return XOR;
    }
}
