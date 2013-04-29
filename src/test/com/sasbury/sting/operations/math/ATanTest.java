package test.com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import test.com.sasbury.sting.operations.*;

public class ATanTest extends NumberOpTest implements StingConstants
{
	public ATanTest(String name)
	{
		super(name);
	}
	
    public String getOperationName()
    {
        return ATAN;
    }

    public double operateOn(double one)
    {
        return Math.atan(one);
    }
}
