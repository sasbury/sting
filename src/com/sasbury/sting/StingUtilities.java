package com.sasbury.sting;

import com.sasbury.util.collections.*;

public class StingUtilities
{
    public static int getOperationIndex(int byteCode)
    {
        return (int)(byteCode & 0xFFFFFF);
    }

    public static int setOperationIndex(int byteCode,int index)
    {
        return (byteCode&(~0xFFFFFF)) | (index);
    }

    public static int getDepth(int byteCode)
    {
        return (int)((byteCode>>24) & 0xFF);
    }

    public static int setDepth(int byteCode,int depth)
    {
        return byteCode&(~((int)0xFF<<24)) | (depth<<24);
    }

    public static void setDepth(IntArray codes,int depth)
    {
        for(int i=0,max=codes.size();i<max;i++)
        {
            codes.set(i,setDepth(codes.get(i),depth));
        }
    }

    public static int getInitialGroupIndex(IntArray program,int index)
    {
        int depth = getDepth(program.get(index));
        int retVal=index;

        if(!StingBuiltinOperations.isStart(getOperationIndex(program.get(index))))
        {
            for(int i=index-1;i>=0;i--)
            {
                if(getDepth(program.get(i))==depth && StingBuiltinOperations.isStart(getOperationIndex(program.get(i))))
                {
                    retVal = i;
                    break;
                }
            }
        }

        return retVal;
    }

    public static int getGroupSize(IntArray program,int index)
    {
        if(!StingBuiltinOperations.isStart(getOperationIndex(program.get(index)))) return 1;
        
        int depth = getDepth(program.get(index));
        int retVal=1;

        for(int i=index+1,max=program.size();i<max;i++)
        {
            if(getDepth(program.get(i))==depth
               && StingBuiltinOperations.isEnd(getOperationIndex(program.get(i))))
            {
                retVal = i+1-index;
                break;
            }
        }

        return retVal;
    }
}
