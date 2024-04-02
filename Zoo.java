import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Zoo {
    private Random ran = new Random();
    private Scanner readString = new Scanner(System.in);
    private Scanner readNumbers = new Scanner(System.in);
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Visitor> visitors = new ArrayList<>();
    private ArrayList<Visit> visits = new ArrayList<>();
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList<Maintenance> maintenance = new ArrayList<>();
    private boolean validAnswer = false;
    private boolean hasVaccines = false;
    private int optionModify = 0;

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

        System.out.println("Ingrese el rol del empleado (sin acentos): ");
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
        double weight = readNumbers.nextDouble();

        ArrayList<String> listDiseases = new ArrayList<>();
        boolean validAnswer1 = false;
        do{
            System.out.println("¿El animal presenta alguna enfermedad? [S/N]: ");
            String hasDiseases = readString.nextLine().toLowerCase();
            
            if(hasDiseases.equals("s")){
                validAnswer1 = true;
                boolean validAnswer2 = false;
                boolean repeat = false;
                do{
                    do{
                        System.out.println("Nombre de la enfermedad: ");
                        String disease = readString.nextLine();
                        listDiseases.add(disease);
                        System.out.println("Enfermedad añadida con éxito.");

                        System.out.println("¿Desea agregar otra enfermedad? [S/N]: ");
                        String hasMoreDiseases = readString.nextLine().toLowerCase();

                        if(hasMoreDiseases.equals("s")){
                            validAnswer2 = true;
                            repeat = true;
                        }
                        else if(hasMoreDiseases.equals("n")){
                            validAnswer2 = true;
                            repeat = false;
                        }
                        else{
                            System.out.println("Ingrese una opción válida.");
                        }
                    } while(!validAnswer2);
                }while(repeat);
            }
            else if(hasDiseases.equals("n")){
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
        hasVaccines = false;
        do{
            System.out.println("¿Cuenta con vacunas? [S/N]: ");
            String vaccineAnswer = readString.nextLine().toLowerCase();

            if(vaccineAnswer.equals("s")){
                validAnswer1 = true;
                hasVaccines = true;
            }
            else if(vaccineAnswer.equals("n")){
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
        if(employees.isEmpty()){
            System.out.println("No se han añadido empleados.");
        }
        else{
            System.out.println("Ingrese el ID del empleado: ");
            int employeeId = readNumbers.nextInt();
            boolean employeeFound = false;

            for(Employee employee : employees){
                if(employee.getId()==employeeId){
                    employeeFound = true;
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

                    validAnswer = false;
                    do{
                        System.out.print("Elige una opción: ");
                        int optionModify = readNumbers.nextInt();

                        switch (optionModify) {
                            case 1:
                            validAnswer = true;
                            System.out.println("Ingrese el nombre del empleado: ");
                                String nameModif = readString.nextLine();
                                employee.setName(nameModif);
                                break;
                            case 2:
                            validAnswer = true;
                            System.out.println("Ingrese los apellidos del empleado: ");
                                String lastNameModif = readString.nextLine();
                                employee.setLastName(lastNameModif);
                                break;
                            case 3:
                            validAnswer = true;
                            System.out.println("Fecha de nacimiento (dd/mm/aaaa): ");
                                String birthDateModif = readString.nextLine();
                                employee.setBirthDate(birthDateModif);
                                break;
                            case 4:
                            validAnswer = true;
                            System.out.println("Fecha de ingreso (dd/mm/aaaa): ");
                                String entryDateModif = readString.nextLine();
                                employee.setEntryDate(entryDateModif);
                                break;
                            case 5:
                            validAnswer = true;
                            System.out.println("Ingrese el RFC: ");
                                String rfcModif = readString.nextLine();
                                employee.setRfc(rfcModif);
                                break;
                            case 6:
                            validAnswer = true;
                            System.out.println("Ingrese la CURP: ");
                                String curpModif = readString.nextLine();
                                employee.setCurp(curpModif);
                                break;
                            case 7:
                            validAnswer = true;
                            System.out.println("Ingrese el salario: ");
                                double salaryModif = readNumbers.nextDouble();
                                employee.setSalary(salaryModif);
                                break;
                            case 8:
                            validAnswer = true;
                            System.out.println("Ingrese el horario de trabajo (hh:mm - hh:mm): ");
                                String workingHoursModif = readString.nextLine();
                                employee.setWorkingHours(workingHoursModif);
                                break;
                            case 9:
                            validAnswer = true;
                            System.out.println("Ingrese el rol del empleado (sin acentos): ");
                                String roleModif = readString.nextLine();
                                employee.setRole(roleModif);
                                break;

                            default:
                            System.out.println("Ingrese una opción válida.");
                            break;
                        }
                    }while(!validAnswer);
                }
            }

            if(!employeeFound){
                System.out.println("Empleado no encontrado.");
            }
        }
    }

    public void modifyVisitor(){
        if(visitors.isEmpty()){
            System.out.println("No se han añadido visitantes.");
        }
        else{
            System.out.println("Ingrese el ID del visitante: ");
            int visitorId = readNumbers.nextInt();
            boolean visitorFound = false;

            for(Visitor visitor : visitors){
                if(visitor.getId()==visitorId){
                    visitorFound = true;
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

                    validAnswer = false;
                    do{
                        System.out.print("Elige una opción: ");
                        int optionModify = readNumbers.nextInt();

                        switch (optionModify) {
                            case 1:
                            validAnswer = true;
                            System.out.println("Ingrese el nombre del visitante: ");
                                String nameVisitorModif = readString.nextLine();
                                visitor.setName(nameVisitorModif);
                                break;
                            case 2:
                            validAnswer = true;
                            System.out.println("Ingrese los apellidos del visitante: ");
                                String lastNameVisitorModif = readString.nextLine();
                                visitor.setLastName(lastNameVisitorModif);
                                break;
                            case 3:
                            validAnswer = true;
                            System.out.println("Fecha de nacimiento (dd/mm/aaaa): ");
                                String birthDateVisitorModif = readString.nextLine();
                                visitor.setBirthDate(birthDateVisitorModif);
                                break;
                            case 4:
                            validAnswer = true;
                            System.out.println("Fecha de registro (dd/mm/aaaa): ");
                                String registerDateVisitorModif = readString.nextLine();
                                visitor.setRegisterDate(registerDateVisitorModif);
                                break;
                            case 5:
                            validAnswer = true;
                            System.out.println("Ingrese la CURP: ");
                            String curpVisitorModif = readString.nextLine();
                                visitor.setCurp(curpVisitorModif);
                                break;

                            default:
                            System.out.println("Ingrese una opción válida.");
                            break;
                        }
                    }while(!validAnswer);
                }
            }
            
            if(!visitorFound){
                System.out.println("No se ha encontrado al visitante.");
            }
        }
    }

    public void modifyAnimal(){
        if(animals.isEmpty()){
            System.out.println("No se han añadido animales.");
        }
        else{
            System.out.println("Ingrese el ID del animal: ");
            int animalId = readNumbers.nextInt();
            boolean animalFound = false;

            for(Animal animal : animals){
                if(animal.getId() == animalId){
                    animalFound = true;
                    System.out.println("+---------------------+");
                    System.out.println("|   MENU MODIFICAR    |");
                    System.out.println("+---------------------+");
                    System.out.println("| OPCION | DESCRIPCION|");
                    System.out.println("+---------------------+");
                    System.out.println("|   1    | Tipo de animal |");
                    System.out.println("|   2    | Fecha de nacimiento (dd/mm/aaaa) |");
                    System.out.println("|   3    | Fecha de llegada (dd/mm/aaaa) |");
                    System.out.println("|   4    | Peso       |");
                    System.out.println("|   5    | Enfermedad |");
                    System.out.println("|   6    | Frecuencia de alimentación |");
                    System.out.println("|   7    | Tipo de alimentación |");
                    System.out.println("|   8    | Cuenta con vacunas |");
                    System.out.println("+---------------------+");

                    validAnswer = false;
                    do{
                        System.out.print("Elige una opción: ");
                        optionModify = readNumbers.nextInt();

                        switch (optionModify) {
                            case 1:
                            validAnswer = true;
                                System.out.println("Ingrese el tipo de animal: ");
                                String animalTypeModif = readString.nextLine();
                                animal.setAnimalType(animalTypeModif);
                                break;

                            case 2:
                            validAnswer = true;
                                System.out.println("Ingrese la fecha de nacimiento (dd/mm/aaaa): ");
                                String animalBirthDateModif = readString.nextLine();
                                animal.setBirthDate(animalBirthDateModif);
                                break;

                            case 3:
                            validAnswer = true;
                                System.out.println("Ingrese la fecha de llegada (dd/mm/aaaa): ");
                                String animalArriveDateModif = readString.nextLine();
                                animal.setArriveDate(animalArriveDateModif);
                                break;

                            case 4:
                            validAnswer = true;
                                System.out.println("Ingrese el peso: ");
                                double animalWeightModif = readNumbers.nextDouble();
                                animal.setWeight(animalWeightModif);
                                break;

                            case 5:
                            validAnswer = true;
                                //Ahorita lo hago xd
                                break;
                            
                            case 6:
                            validAnswer = true;
                                System.out.println("Ingrese la frecuencia de alimentación: ");
                                String animalFeedFrequencyModif = readString.nextLine();
                                animal.setFeedFrequency(animalFeedFrequencyModif);
                                break;

                            case 7:
                            validAnswer = true;
                                System.out.println("Ingrese el tipo de alimentación: ");
                                String animalFeedTypeModif = readString.nextLine();
                                animal.setFeedType(animalFeedTypeModif);
                                break;

                            case 8:
                            validAnswer = true;
                                boolean validAnswerVaccines = false;
                                hasVaccines = false;
                                do{
                                    System.out.println("¿Cuenta con vacunas? [S/N]: ");
                                    String vaccineAnswer = readString.nextLine().toLowerCase();
                        
                                    if(vaccineAnswer.equals("s")){
                                        validAnswerVaccines = true;
                                        hasVaccines = true;
                                    }
                                    else if(vaccineAnswer.equals("n")){
                                        validAnswerVaccines = true;
                                    }
                                    else{
                                        System.out.println("Ingrese una opción válida.");
                                    }
                                } while(!validAnswerVaccines);
                                animal.setHasVaccines(hasVaccines);
                                break;

                            default:
                                System.out.println("Ingrese una opción válida.");
                                break;
                        }
                    }while(!validAnswer);
                }
            }
            
            if(!animalFound){
                System.out.println("No se ha encontrado ningún animal para este ID.");
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
                        if(employee.getId() == idGuide && employee.isGuide()){
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
                    validAnswer = false;
                    do{
                        System.out.print("¿Desea agregar más visitantes? [S/N]: ");
                        String answerAddVisitors = readString.nextLine().toLowerCase();
                        if(answerAddVisitors.equals("n")){
                            finish = true;
                            validAnswer = true;
                        }
                        else if(answerAddVisitors.equals("s")){
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

    public void registerMaintenance(){
        if(thereAreMaintenanceEmployees()){
            if(animals.isEmpty()){
                System.out.println("No se han añadido animales.");
            }
            else{
                System.out.println("Ingrese el ID del empleado a cargo: ");
                int employeeInChargeId = readNumbers.nextInt();
                
                Employee employeeInCharge = null;
                boolean employeeFoundMaintenance = false;

                do{
                    for(Employee employee : employees){
                        if(employee.getId() == employeeInChargeId && employee.hasMaintenanceRole()){
                            employee.setIsInAMaintenanceProcess(true);
                            employeeFoundMaintenance = true;
                            employeeInCharge = employee;
                            System.out.println("Empleado añadido con éxito.");
                        }
                    }
                    if(!employeeFoundMaintenance){
                        System.out.println("No se ha encontrado empleado de mantenimiento con ese ID.");
                    }
                }while(!employeeFoundMaintenance);

                System.out.println("Ingrese el ID del animal involucrado: ");
                int animalIdMaintenance = readNumbers.nextInt(); 

                Animal animalMaintenance = null;
                boolean animalFoundMaintenance = false;

                do{
                    for(Animal animal : animals){
                        if(animal.getId() == animalIdMaintenance){
                            animal.setIsInAMaintenanceProcess(true);
                            animalFoundMaintenance = true;
                            animalMaintenance = animal;
                            System.out.println("Animal añadido con éxito.");
                        }
                    }
                    if(!animalFoundMaintenance){
                        System.out.println("No se ha encontrado ningún animal con ese ID.");
                    }
                } while(!animalFoundMaintenance);

                System.out.println("Ingrese el proceso que se realizó: ");
                String processName = readString.nextLine();

                System.out.println("Fecha en que se realizó el proceso: ");
                String date = readString.nextLine();

                System.out.println("Observaciones (Opcional, sino desea añadir ninguna simplemente presione Enter: )");
                String observations = readString.nextLine();

                maintenance.add(new Maintenance(employeeInCharge, animalMaintenance, processName, date, observations));
            }
        }
        else{
            System.out.println("No se han añadido empleados con el rol de mantenimiento.");
        }
    }

    public boolean thereAreMaintenanceEmployees(){
        boolean thereAreMaintenanceEmployees = false;
        
        for(Employee employee : employees){
            if(employee.hasMaintenanceRole()){
                thereAreMaintenanceEmployees = true;
            }
        }

        return thereAreMaintenanceEmployees;
    }
}