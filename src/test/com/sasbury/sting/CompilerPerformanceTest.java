package test.com.sasbury.sting;

import com.sasbury.sting.*;
import com.sasbury.util.collections.*;

public class CompilerPerformanceTest
{
    public static void main(String args[])
    {
        try
        {
            String prog = "read write plus minus div mult cos sin tan abs 1 2 3 4 exec floor forall ifeq loop ceil";
            StingProgram program = new StingProgram(prog);
            int size=2;

            for(int i=0,max=size;i<max;i++)
            {
                prog = prog+" "+prog;
            }

            int loops = 1000000;
            IntArray compiled=new IntArray();
            long start = System.currentTimeMillis();

            for(int i=0,max=loops;i<max;i++)
            {
                compiled = program.getByteCode();
                program.clearByteCode();
            }

            long end = System.currentTimeMillis();

            System.out.println("Total time for "+loops+" compilations was "+(end-start)+"ms");
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }
}
