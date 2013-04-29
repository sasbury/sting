package test.com.sasbury.sting.operations.math;

import com.sasbury.sting.*;
import test.com.sasbury.sting.operations.*;

public class LogTest extends NumberOpTest implements StingConstants
{
	public LogTest(String name)
	{
		super(name);
	}
	
    public String getOperationName()
    {
        return LOG;
    }

    public double operateOn(double one)
    {
        return (one<=0)?one:Math.log(one);
    }
}
