package test.com.sasbury.sting.operations;

public class ModuloTest extends ArithmeticTest
{
	public ModuloTest(String name)
	{
		super(name);
	}
	
    public double combine(double one, double two)
    {
        return one%two;
    }

    public String getOperationName()
    {
        return MODULO;
    }
}
