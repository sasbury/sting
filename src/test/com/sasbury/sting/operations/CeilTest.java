package test.com.sasbury.sting.operations;

public class CeilTest extends NumberOpTest
{
	public CeilTest(String name)
	{
		super(name);
	}
	
    public String getOperationName()
    {
        return CEIL;
    }

    public double operateOn(double one)
    {
        return (double)Math.ceil(one);
    }
}
