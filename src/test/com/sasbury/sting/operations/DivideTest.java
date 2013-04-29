package test.com.sasbury.sting.operations;

public class DivideTest extends ArithmeticTest
{
	public DivideTest(String name)
	{
		super(name);
	}
	
    public double combine(double one, double two)
    {
        return one/two;
    }

    public String getOperationName()
    {
        return DIVIDE;
    }
}
