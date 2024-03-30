import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Zoo {
    Random ran = new Random();
    Scanner readString = new Scanner(System.in);
    Scanner readNumbers = new Scanner(System.in);
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Visitor> visitors = new ArrayList<>();

    public Zoo(){

    }

    public void addEmployee(){
        System.out.println("Ingrese el nombre del empleado: ");
        String name = readString.nextLine();

        System.out.println("Ingrese los apellidos del empleado: ");
        String lastName = readString.nextLine();

        System.out.println("Fecha de nacimiento (dd/mm/aaaa): ");
        String birthDate = readString.nextLine();

        System.out.println("Fecha de ingreso (dd/mm/aaaa): ");
        String entryDate = readString.nextLine();

        System.out.println("Ingrese el RFC: ");
        String rfc = readString.nextLine();

        System.out.println("Ingrese la CURP: ");
        String curp = readString.nextLine();

        System.out.println("Ingrese el salario: ");
        double salary = readNumbers.nextDouble();

        System.out.println("Ingrese el horario de trabajo (hh:mm - hh:mm): ");
        String workingHours = readString.nextLine();

        System.out.println("Ingrese el rol del empleado: ");
        String role = readString.nextLine();

        employees.add(new Employee(name, lastName, birthDate, entryDate, rfc, curp, salary, workingHours, role, generateRandomID()));
    }

    public void addVisitor(){
        System.out.println("Ingrese el nombre del visitante: ");
        String name = readString.nextLine();

        System.out.println("Ingrese los apellidos del visitante: ");
        String lastName = readString.nextLine();

        System.out.println("Fecha de nacimiento (dd/mm/aaaa): ");
        String birthDate = readString.nextLine();

        System.out.println("Ingrese la CURP: ");
        String curp = readString.nextLine();

        System.out.println("Fecha de registro (dd/mm/aaaa): ");
        String registerDate = readString.nextLine();

        visitors.add(new Visitor(name, lastName, birthDate, curp, registerDate, generateRandomID()));
    }

    private int generateRandomID(){
        int id = ran.nextInt(100, 9999);
        boolean repetido = false;
        do{
            for(Employee employee : employees){
                if(employee.getId() == id){
                    repetido = true;
                }
            }
            for(Visitor visitor : visitors){
                if(visitor.getId() == id){
                    repetido = true;
                }
            }
        } while(repetido);
        return id;
    }
}