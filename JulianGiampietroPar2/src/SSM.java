import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class SSM
{
    private int kitsDisp;
    private List<Paciente> registerPerson;
    private Set<Integer> dnis;
    private int KitNext;

    private Map<Integer, RegistroTest> registrosTest = new HashMap<>();
    private Throwable e;


    public SSM(int kitsDisp)
    {
        this.kitsDisp = kitsDisp;
        this.registerPerson = new ArrayList<>();
        this.dnis = new HashSet<>();
        this.KitNext = 1;
    }

    public void consultarMasKits()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n ----------------------------------SSM----------------------------------\n ");
        System.out.print("\n ¿Cuantos Kit's desea?\n ");
        System.out.print("\n ----------------------------------SSM----------------------------------\n ");
        int nuevosKits = scanner.nextInt();
        kitsDisp += nuevosKits;
    }

    public void registrarPaciente(String nameAndLastName, Integer edad, String barrio, Integer dni, String ocupacion) throws ExceptionKIT
    {
        if (dnis.contains(dni))
        {
            System.out.println("El dni ya fue registrado.");
            return;
        }

        if (kitsDisp <= 0) {
            throw new ExceptionKIT("SSM:  ---Se acabaron los kit---");
        }

        Paciente nuevoPaciente = new Paciente(nameAndLastName, edad, barrio, dni, ocupacion);
        nuevoPaciente.setNumeroKit(KitNext);
        KitNext++;
        registerPerson.add(nuevoPaciente);
        dnis.add(dni);
        kitsDisp--;

    }

    public void mostrarPaciente()
    {
        for (Paciente paciente : registerPerson)
        {
            System.out.println(paciente);
        }
    }



    public void randomTest()
    {
        Random temp = new Random();
        for (Paciente paciente : registerPerson)
        {
            double temperatura = 36 + (39 - 36) * temp.nextDouble();
            RegistroTest registro = new RegistroTest(paciente.getDni(), temperatura);
            registrosTest.put(paciente.getNumeroKit(), registro);
        }
    }

    public void showTest()
    {
        for (Map.Entry<Integer, RegistroTest> entry : registrosTest.entrySet())
        {
            System.out.println("Kit: " + entry.getKey() + "," + entry.getValue());
        }
    }
    public void Aislamiento() {
    try {
        ObjectMapper archi = new ObjectMapper();
        Paciente[] pacientesUrgentes = archi.readValue(new File("urgencia.json"), Paciente[].class);
        List<Paciente> pacientesAislados = new ArrayList<>();

        for (Paciente paciente : pacientesUrgentes) {
            RegistroTest registro = registrosTest.get(paciente.getNumeroKit());
            if (registro != null && registro.getTemperatura() >= 38) {
                ExceptionA e = new ExceptionA(paciente.getNumeroKit(), paciente.getBarrio());
                System.out.println("------------------------------------SSM------------------------------------");
                System.out.println(" DNI y Temperatura del paciente aislado: " + registro.toString());
                System.out.println("Aislando..... ");
                pacientesAislados.add(paciente);
            }
        }
    } catch (IOException e) {
        System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
    }

    public void generarJson() {
        List<Paciente> sanos = new ArrayList<>();
        List<Map<String, Object>> aislar = new ArrayList<>();

        for (Paciente paciente : registerPerson) {
            RegistroTest registro = registrosTest.get(paciente.getNumeroKit());
            if (registro != null) {
                if (registro.getTemperatura() < 38) {
                    sanos.add(paciente);
                } else {
                    Map<String, Object> asilar = new HashMap<>();
                    asilar.put("kit", paciente.getNumeroKit());
                    asilar.put("temperatura", registro.getTemperatura());
                    asilar.put("barrio", paciente.getBarrio());
                    aislar.add(asilar);
                }
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("sanos", sanos);
        result.put("aislar", aislar);


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("resultados.json"), result);

        } catch (IOException e) {
            e.getMessage();
        }
    }
}