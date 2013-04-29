package test.com.sasbury.sting.operations;

public class AndTest extends ArithmeticTest
{
	public AndTest(String name)
	{
		super(name);
	}
	
    public double combine(double one, double two)
    {
        return (one>0 && two>0)?1:-1;
    }

    public String getOperationName()
    {
        return AND;
    }
}
