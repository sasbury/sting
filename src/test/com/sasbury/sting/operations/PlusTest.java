package test.com.sasbury.sting.operations;

public class PlusTest extends ArithmeticTest
{
	public PlusTest(String name)
	{
		super(name);
	}
	
    public double combine(double one, double two)
    {
        return one+two;
    }

    public String getOperationName()
    {
        return PLUS;
    }
}
