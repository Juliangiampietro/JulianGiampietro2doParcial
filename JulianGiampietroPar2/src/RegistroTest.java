public class RegistroTest
{
    private Integer dni;
    private double temperatura;

    public RegistroTest(Integer dni, double temperatura) {
        this.dni = dni;
        this.temperatura = temperatura;
    }

    public Integer getDni() {
        return dni;
    }

    public double getTemperatura() {
        return temperatura;
    }



    @Override
    public String toString() {
        return "DNI: " + dni + ", Temperatura: " + temperatura;
    }
}