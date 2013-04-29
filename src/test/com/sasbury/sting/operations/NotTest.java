package test.com.sasbury.sting.operations;

public class NotTest extends NumberOpTest
{
	public NotTest(String name)
	{
		super(name);
	}
	
    public String getOperationName()
    {
        return NOT;
    }

    public double operateOn(double one)
    {
        return (one<=0)?1:-1;
    }
}
