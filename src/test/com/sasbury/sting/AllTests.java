package test.com.sasbury.sting;

import junit.framework.*;

import test.com.sasbury.sting.operations.*;
import test.com.sasbury.sting.operations.math.*;

public class AllTests extends TestSuite
{
    public static Test suite()
    {
        TestSuite suite = new TestSuite();
        //$JUnit-BEGIN$

        suite.addTestSuite(GarbageProgramTest.class);
        suite.addTestSuite(WhiteSpaceTest.class);

        suite.addTestSuite(AddTest.class);
        suite.addTestSuite(AndTest.class);
        suite.addTestSuite(CeilTest.class);
        suite.addTestSuite(ClearTest.class);
        suite.addTestSuite(CommentTest.class);
        suite.addTestSuite(CopyTest.class);
        suite.addTestSuite(DivideTest.class);
        suite.addTestSuite(DupTest.class);
        suite.addTestSuite(EmptyForAllTest.class);
        suite.addTestSuite(EscapeStringTest.class);
        suite.addTestSuite(ExecTest.class);
        suite.addTestSuite(FloorTest.class);
        suite.addTestSuite(ForAllMemTest.class);
        suite.addTestSuite(ForAllStringTest.class);
        suite.addTestSuite(ForAllTest.class);
        suite.addTestSuite(IfEqTest.class);
        suite.addTestSuite(IfGtTest.class);
        suite.addTestSuite(InputTest.class);
        suite.addTestSuite(LoopTest.class);
        suite.addTestSuite(MarkTest.class);
        suite.addTestSuite(MinusTest.class);
        suite.addTestSuite(ModuloTest.class);
        suite.addTestSuite(NegTest.class);
        suite.addTestSuite(NestedArrayTest.class);
        suite.addTestSuite(NoOpTest.class);
        suite.addTestSuite(NotTest.class);
        suite.addTestSuite(NullTest.class);
        suite.addTestSuite(OrTest.class);
        suite.addTestSuite(OutputTest.class);
        suite.addTestSuite(PlusTest.class);
        suite.addTestSuite(PopTest.class);
        suite.addTestSuite(ProcedureArrayTest.class);
        suite.addTestSuite(PushNumberTest.class);
        suite.addTestSuite(PushStringTest.class);
        suite.addTestSuite(ReadWriteTest.class);
        suite.addTestSuite(RollTest.class);
        suite.addTestSuite(SimpleArrayTest.class);
        suite.addTestSuite(SimpleExecTest.class);
        suite.addTestSuite(SimpleLoopTest.class);
        suite.addTestSuite(SizeTest.class);
        suite.addTestSuite(SwapTest.class);
        suite.addTestSuite(SymbolOperatorsTest.class);
        suite.addTestSuite(TimesTest.class);
        suite.addTestSuite(WorkingTest.class);
        suite.addTestSuite(XorTest.class);

        suite.addTestSuite(AbsTest.class);
        suite.addTestSuite(ACosTest.class);
        suite.addTestSuite(ASinTest.class);
        suite.addTestSuite(ATanTest.class);
        suite.addTestSuite(CosTest.class);
        suite.addTestSuite(ETest.class);
        suite.addTestSuite(ExpTest.class);
        suite.addTestSuite(LogTest.class);
        suite.addTestSuite(MaxTest.class);
        suite.addTestSuite(MinTest.class);
        suite.addTestSuite(PiTest.class);
        suite.addTestSuite(PowTest.class);
        suite.addTestSuite(SinTest.class);
        suite.addTestSuite(SqrtTest.class);
        suite.addTestSuite(TanTest.class);
        
        //$JUnit-END$
        return suite;
    }

}
