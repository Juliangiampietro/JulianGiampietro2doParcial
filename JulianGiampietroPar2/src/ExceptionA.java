public class ExceptionA extends Exception
{
    private int numeroKit;
    private String barrio;

    public ExceptionA(int numeroKit, String barrio)
    {
        super("------------------------------------AISLADO------------------------------------");
        this.numeroKit = numeroKit;
        this.barrio = barrio;
    }

    public int getNumeroKit()
    {
        return numeroKit;
    }

    public String getBarrio()
    {
        return barrio;
    }
}

