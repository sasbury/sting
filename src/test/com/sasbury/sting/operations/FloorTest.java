package test.com.sasbury.sting.operations;

public class FloorTest extends NumberOpTest
{
	public FloorTest(String name)
	{
		super(name);
	}
	
    public String getOperationName()
    {
        return FLOOR;
    }

    public double operateOn(double one)
    {
        return (double)Math.floor(one);
    }
}
