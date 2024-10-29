public class Main {
    public static void main(String[] args)
    {

        SSM SSM = new SSM(1);
        try
        {
            SSM.registrarPaciente("Julian Giampietro", 25, "9 de julio", 41854082, "programador");
            SSM.registrarPaciente("Bauti Hernandez",  27, "San jorge", 416565, "pescador");
            SSM.registrarPaciente(" Maik Tower", 21, "Centro", 4223233, "Piloto F2");
            SSM.registrarPaciente("Pepe Argento",63,"Guemes",6565656,"Desempleado");
            SSM.registrarPaciente("Pedro Aurelio",23,"Parque Camet",65656565,"pecador");
        } catch (ExceptionKIT e)
        {

            System.out.println(e.getMessage());
            SSM.consultarMasKits();

            try
            {
                SSM.registrarPaciente("Pepe", 23, "Luz", 9686565, "estudiante");
            } catch (ExceptionKIT ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        SSM.mostrarPaciente();
        SSM.randomTest();
        SSM.showTest();
        SSM.Aislamiento();
        SSM.generarJson();



    }
}

