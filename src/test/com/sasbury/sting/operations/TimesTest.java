package test.com.sasbury.sting.operations;

public class TimesTest extends ArithmeticTest
{
	public TimesTest(String name)
	{
		super(name);
	}
	
    public double combine(double one, double two)
    {
        return one*two;
    }

    public String getOperationName()
    {
        return TIMES;
    }
}
