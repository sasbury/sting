package test.com.sasbury.sting.operations.math;

import test.com.sasbury.sting.operations.*;

public class PowTest extends ArithmeticTest
{
    public PowTest(String name)
    {
        super(name);
    }
    
    public double combine(double one, double two)
    {
        double retVal = Math.pow(one,two);
        if(Double.isNaN(retVal)) retVal = 0;
        return retVal;
    }

    public String getOperationName()
    {
        return POW;
    }
}
