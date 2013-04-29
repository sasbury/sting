package com.sasbury.util;

import java.math.*;

/**
 * Static methods for working with numbers.
 */
public class NumberUtils
{
    public static int ceilPrime(int aValue)
    {
        int retVal;

        retVal = aValue;

        if(aValue <= 5)
            retVal = 5;
        else if(aValue <= 7)
            retVal = 7;
        else if(aValue <= 13)
            retVal = 13;
        else if(aValue <= 17)
            retVal = 17;
        else if(aValue <= 51)
            retVal = 51;
        else if(aValue <= 71)
            retVal = 71;
        else if(aValue <= 125)
            retVal = 97;
        else if(aValue <= 275)
            retVal = 241;
        else if(aValue <= 425)
            retVal = 397;
        else if(aValue <= 525)
            retVal = 499;
        else if(aValue <= 800)
            retVal = 743;
        else if(aValue <= 1100)
            retVal = 997;
        else if(aValue <= 1750)
            retVal = 1499;
        else if(aValue <= 2250)
            retVal = 1999;
        else if(aValue <= 4250)
            retVal = 3989;
        else if(aValue <= 5500)
            retVal = 4999;
        else if(aValue <= 8000)
            retVal = 7499;
        else if(aValue <= 11000)
            retVal = 9973;
        else if((aValue % 2) == 0) retVal += 1;

        return retVal;
    }
}
