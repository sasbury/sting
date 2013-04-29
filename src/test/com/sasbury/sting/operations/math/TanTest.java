package test.com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import test.com.sasbury.sting.operations.*;

public class TanTest extends NumberOpTest implements StingConstants
{
	public TanTest(String name)
	{
		super(name);
	}
	
    public String getOperationName()
    {
        return TAN;
    }

    public double operateOn(double one)
    {
        return Math.tan(one);
    }
}
