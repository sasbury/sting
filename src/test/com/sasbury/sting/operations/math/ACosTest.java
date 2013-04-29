package test.com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import test.com.sasbury.sting.operations.*;

public class ACosTest extends NumberOpTest implements StingConstants
{
	public ACosTest(String name)
	{
		super(name);
	}
	
    public String getOperationName()
    {
        return ACOS;
    }

    public double operateOn(double one)
    {
        return (one<0 || one>1)?one:Math.acos(one);
    }
}
