package test.com.sasbury.sting.operations;

public class MinusTest extends ArithmeticTest
{
	public MinusTest(String name)
	{
		super(name);
	}
	
    public double combine(double one, double two)
    {
        return one-two;
    }

    public String getOperationName()
    {
        return MINUS;
    }
}
