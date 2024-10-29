public class Paciente {
    private String NameAndLastName;
    private Integer edad;
    private String barrio;
    private Integer dni;
    private String ocupacion;
    private Integer numeroKit;
    public Paciente() {
    }

    public Paciente(String NameAndLastName, Integer edad, String barrio, Integer dni, String ocupacion ) {
        this.NameAndLastName = NameAndLastName;
        this.edad = edad;
        this.barrio = barrio;
        this.dni = dni;
        this.ocupacion = ocupacion;
    }

    public String getNameAndLastName() {
        return NameAndLastName;
    }

    public void setNameAndLastName(String nameAndLastName) {
        this.NameAndLastName = nameAndLastName;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "Nombre Y Apellido='" + NameAndLastName + '\'' +
                ", Edad=" + edad +
                ", barrio='" + barrio + '\'' +
                ", dni=" + dni +
                ", ocupacion='" + ocupacion + '\'' +
                '}';
    }

    public Integer getNumeroKit()
    {
        return numeroKit;
    }
    public void setNumeroKit(int numeroKit)
    {
        this.numeroKit = numeroKit;
    }
}
