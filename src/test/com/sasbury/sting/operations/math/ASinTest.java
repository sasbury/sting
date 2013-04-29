package test.com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import test.com.sasbury.sting.operations.*;

public class ASinTest extends NumberOpTest implements StingConstants
{
	public ASinTest(String name)
	{
		super(name);
	}
	
    public String getOperationName()
    {
        return ASIN;
    }

    public double operateOn(double one)
    {
        return (one<0 || one>1)?one:Math.asin(one);
    }
}
