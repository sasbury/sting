package test.com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import test.com.sasbury.sting.operations.*;

public class CosTest extends NumberOpTest implements StingConstants
{
	public CosTest(String name)
	{
		super(name);
	}
	
    public String getOperationName()
    {
        return COS;
    }

    public double operateOn(double one)
    {
        return Math.cos(one);
    }
}
