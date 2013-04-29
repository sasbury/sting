package test.com.sasbury.sting.operations;

public class NegTest extends NumberOpTest
{
	public NegTest(String name)
	{
		super(name);
	}
	
    public String getOperationName()
    {
        return NEG;
    }

    public double operateOn(double one)
    {
        return (one==0)?0:-one;
    }
}
