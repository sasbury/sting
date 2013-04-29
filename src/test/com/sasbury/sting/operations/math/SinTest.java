package test.com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import test.com.sasbury.sting.operations.*;

public class SinTest extends NumberOpTest implements StingConstants
{
	public SinTest(String name)
	{
		super(name);
	}
	
    public String getOperationName()
    {
        return SIN;
    }

    public double operateOn(double one)
    {
        return Math.sin(one);
    }
}
