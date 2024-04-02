import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Zoo {
    Random ran = new Random();
    Scanner readString = new Scanner(System.in);
    Scanner readNumbers = new Scanner(System.in);
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Visitor> visitors = new ArrayList<>();
    private ArrayList<Visit> visits = new ArrayList<>();
    private ArrayList<Animal> animals = new ArrayList<>();

    public Zoo(){

    }
    

    public ArrayList<Employee> getEmployees() {
        return employees;
    }


    public ArrayList<Visitor> getVisitors() {
        return visitors;
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

    public void addAnimal(){
        System.out.println("Ingrese el tipo de animal: ");
        String animalType = readString.nextLine();

        System.out.println("Ingrese la fecha de nacimiento del animal (dd/mm/aaaa): ");
        String birthDate = readString.nextLine();

        System.out.println("Ingrese la fecha de llegada del animal (dd/mm/aaaa): ");
        String arriveDate = readString.nextLine();

        System.out.println("Ingrese el peso del animal: ");
        int weight = readNumbers.nextInt();

        ArrayList<String> listDiseases = new ArrayList<>();
        boolean validAnswer1 = false;
        do{
            System.out.println("¿El animal presenta alguna enfermedad? [S/N]: ");
            char hasDiseases = readString.nextLine().charAt(0);
            
            if(hasDiseases == 's' || hasDiseases == 'S'){
                validAnswer1 = true;
                boolean validAnswer2 = false;
                boolean repeat = false;
                do{
                        System.out.println("Nombre de la enfermedad: ");
                        String disease = readString.nextLine();
                        listDiseases.add(disease);
                        System.out.println("Enfermedad añadida con éxito.");

                        System.out.println("¿Desea agregar otra enfermedad? [S/N]: ");
                        char hasMoreDiseases = readString.nextLine().charAt(0);

                    do{
                        if(hasMoreDiseases == 's' || hasMoreDiseases == 'S'){
                            repeat = true;
                        }
                        else if(hasMoreDiseases == 'n' || hasMoreDiseases == 'N'){
                            repeat = false;
                        }
                        else{
                            System.out.println("Ingrese una opción válida.");
                        }
                    } while(!validAnswer2);
                }while(repeat);
            }
            else if(hasDiseases == 'n' || hasDiseases == 'N'){
                validAnswer1 = true;
            }
            else{
                System.out.println("Ingrese una opción válida.");
            }
        } while(!validAnswer1);

        System.out.println("Ingrese la frecuencia de alimentación del animal: ");
        String feedFrequency = readString.nextLine();

        System.out.println("Ingrese el tipo de alimentación del animal: ");
        String feedType = readString.nextLine();

        validAnswer1 = false;
        boolean hasVaccines = false;
        do{
            System.out.println("¿Cuenta con vacunas? [S/N]: ");
            char vaccineAnswer = readString.nextLine().charAt(0);

            if(vaccineAnswer == 'S' || vaccineAnswer == 's'){
                validAnswer1 = true;
                hasVaccines = true;
            }
            else if(vaccineAnswer == 'N' || vaccineAnswer == 'n'){
                validAnswer1 = true;
            }
            else{
                System.out.println("Ingrese una opción válida.");
            }
        } while(!validAnswer1);

        animals.add(new Animal(animalType, birthDate, arriveDate, weight, listDiseases, feedFrequency, feedType, hasVaccines, generateRandomID()));
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
            for(Animal animal : animals){
                if(animal.getId() == id){
                    repetido = true;
                }
            }
        } while(repetido);
        return id;
    }

    public void modifyEmployee(){
        System.out.println("Ingrese el ID del empleado: ");
        int id = readNumbers.nextInt();

        for(Employee employee : employees){
            if(employee.getId()==id){
                System.out.println("+---------------------+");
                System.out.println("|   MENU MODIFICAR    |");
                System.out.println("+---------------------+");
                System.out.println("| OPCION | DESCRIPCION|");
                System.out.println("+---------------------+");
                System.out.println("|   1    | Nombre     |");
                System.out.println("|   2    | Apellidos  |");
                System.out.println("|   3    | Fecha de nacimiento (dd/mm/aaaa) |");
                System.out.println("|   4    | Fecha de ingreso (dd/mm/aaaa) |");
                System.out.println("|   5    | RFC        |");
                System.out.println("|   6    | CURP       |");
                System.out.println("|   7    | Salario    |");
                System.out.println("|   8    | Horario de trabajo |");
                System.out.println("|   9    | Rol        |");
                System.out.println("+---------------------+");
                System.out.print("Elige una opción: ");
                int optionModify = readNumbers.nextInt();

                switch (optionModify) {
                    case 1:
                    System.out.println("Ingrese el nombre del empleado: ");
                        String nameModif = readString.nextLine();
                        employee.setName(nameModif);
                        break;
                    case 2:
                    System.out.println("Ingrese los apellidos del empleado: ");
                        String lastNameModif = readString.nextLine();
                        employee.setLastName(lastNameModif);
                        break;
                    case 3:
                    System.out.println("Fecha de nacimiento (dd/mm/aaaa): ");
                        String birthDateModif = readString.nextLine();
                        employee.setBirthDate(birthDateModif);
                        break;
                    case 4:
                    System.out.println("Fecha de ingreso (dd/mm/aaaa): ");
                        String entryDateModif = readString.nextLine();
                        employee.setEntryDate(entryDateModif);
                        break;
                    case 5:
                    System.out.println("Ingrese el RFC: ");
                        String rfcModif = readString.nextLine();
                        employee.setRfc(rfcModif);
                        break;
                    case 6:
                    System.out.println("Ingrese la CURP: ");
                        String curpModif = readString.nextLine();
                        employee.setCurp(curpModif);
                        break;
                    case 7:
                    System.out.println("Ingrese el salario: ");
                        double salaryModif = readNumbers.nextDouble();
                        employee.setSalary(salaryModif);
                        break;
                    case 8:
                    System.out.println("Ingrese el horario de trabajo (hh:mm - hh:mm): ");
                        String workingHoursModif = readString.nextLine();
                        employee.setWorkingHours(workingHoursModif);
                        break;
                    case 9:
                    System.out.println("Ingrese el rol del empleado: ");
                        String roleModif = readString.nextLine();
                        employee.setRole(roleModif);
                        break;

                }
            }
        }
    }

    public void modifyVisitor(){
        System.out.println("Ingrese el ID del visitante: ");
        int id = readNumbers.nextInt();

        for(Visitor visitor : visitors){
            if(visitor.getId()==id){
                System.out.println("+---------------------+");
                System.out.println("|   MENU MODIFICAR    |");
                System.out.println("+---------------------+");
                System.out.println("| OPCION | DESCRIPCION|");
                System.out.println("+---------------------+");
                System.out.println("|   1    | Nombre     |");
                System.out.println("|   2    | Apellidos  |");
                System.out.println("|   3    | Fecha de nacimiento (dd/mm/aaaa) |");
                System.out.println("|   4    | Fecha de registro (dd/mm/aaaa) |");
                System.out.println("|   5    | CURP       |");
                System.out.println("+---------------------+");
                System.out.print("Elige una opción: ");
                int optionModify = readNumbers.nextInt();

                switch (optionModify) {
                    case 1:
                    System.out.println("Ingrese el nombre del visitante: ");
                        String nameVisitorModif = readString.nextLine();
                        visitor.setName(nameVisitorModif);
                        break;
                    case 2:
                    System.out.println("Ingrese los apellidos del visitante: ");
                        String lastNameVisitorModif = readString.nextLine();
                        visitor.setLastName(lastNameVisitorModif);
                        break;
                    case 3:
                    System.out.println("Fecha de nacimiento (dd/mm/aaaa): ");
                        String birthDateVisitorModif = readString.nextLine();
                        visitor.setBirthDate(birthDateVisitorModif);
                        break;
                    case 4:
                    System.out.println("Fecha de registro (dd/mm/aaaa): ");
                        String registerDateVisitorModif = readString.nextLine();
                        visitor.setRegisterDate(registerDateVisitorModif);
                        break;
                    case 5:
                    System.out.println("Ingrese la CURP: ");
                    String curpVisitorModif = readString.nextLine();
                        visitor.setCurp(curpVisitorModif);
                        break;

                }
            }
        }
    }

    public void registerVisit(){
        if(thereAreGuides()){
            if(visitors.isEmpty()){
                System.out.println("No se han añadido visitantes.");
            }
            else{
                System.out.print("Ingrese la fecha de la visita: ");
                String visitDate = readString.nextLine();

                Employee guideInCharge = null;
                boolean guideFound = false;
                do{
                    System.out.print("Ingrese el ID del guía a cargo: ");
                    int idGuide = readNumbers.nextInt();

                    for(Employee employee : employees){
                        if(employee.getId() == idGuide){
                            if(employee.isGuide()){
                                employee.setIsInAVisit(true);
                                guideFound = true;
                                guideInCharge = employee;
                                System.out.println("Guía añadido éxitosamente.");
                            }
                        }
                    }

                    if(!guideFound){
                        System.out.println("No se ha encontrado ningún guía con ese ID. Intente nuevamente.");
                    }
                } while(!guideFound);

                boolean finish = false;
                ArrayList<Visitor> listVisitors = new ArrayList<>();
                int numberOfVisitors = 0;
                do{
                    boolean visitorFound = false;
                    do{
                        System.out.print("Ingrese el ID del visitante a agregar: ");
                        int idVisitor = readNumbers.nextInt();
                        for(Visitor visitor : visitors){
                            if(visitor.getId() == idVisitor){
                                if(listVisitors.isEmpty()){
                                    visitorFound = true;
                                    listVisitors.add(visitor);
                                    visitor.setIsInAVisit(true);
                                    numberOfVisitors++;
                                    System.out.println("Visitante añadido con éxito.");
                                }
                                else{
                                    boolean repeated = false;
                                    for(Visitor visitorListed : listVisitors){
                                        if(visitorListed.getId() == idVisitor){
                                            repeated = true;
                                            System.out.println("Ya se ha agregado este visitante a la visita.");
                                        }
                                    }
                                    if(!repeated){
                                        visitorFound = true;
                                        listVisitors.add(visitor);
                                        visitor.setIsInAVisit(true);
                                        numberOfVisitors++;
                                        System.out.println("Visitante añadido con éxito.");
                                    }
                                }
                            }
                        }
                        if(!visitorFound){
                            System.out.println("No se ha podido encontrar ese visitante.");
                        }
                    } while(!visitorFound);
                    boolean validAnswer = false;
                    do{
                        System.out.print("¿Desea agregar más visitantes? [S/N]: ");
                        char answerAddVisitors = readString.nextLine().charAt(0);
                        if(answerAddVisitors == 'N' || answerAddVisitors == 'n'){
                            finish = true;
                            validAnswer = true;
                        }
                        else if(answerAddVisitors == 'S' || answerAddVisitors == 's'){
                            validAnswer = true;
                        }
                        else{
                            System.out.println("Ingrese una opción válida");
                        }
                    } while(!validAnswer);
                } while(!finish);

                visits.add(new Visit(visitDate, guideInCharge, listVisitors, numberOfVisitors));
            }
        }
        else{
            System.out.println("No se han añadido empleados con el rol de guía.");
        }
    }

    public boolean thereAreGuides(){
        boolean thereAreGuides = false;
        for(Employee employee : employees){
            if(employee.isGuide()){
                thereAreGuides = true;
            }
        }
        return thereAreGuides;
    }


}