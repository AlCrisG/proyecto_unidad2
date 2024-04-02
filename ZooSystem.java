import java.util.Scanner;

public class ZooSystem {
    private final String PASSWORD = "ZooManager";
    private Scanner scanner = new Scanner(System.in);
    Zoo zoo = new Zoo();
    public void ExecuteProgram() {
        boolean isCorrectPassword = false;

        do {
            System.out.println("\n*** BIENVENIDO ***");
            System.out.println("Ingresa la contraseña");
            String password = scanner.nextLine();

            if (password.equals(PASSWORD)) {
                isCorrectPassword = true;
                executeMenu();
            } else {
                System.out.println("\nContraseña incorrecta, intenta de nuevo");
            }
        } while (!isCorrectPassword);
    }

    private void executeMenu() {

        do {
            System.out.println("+---------------------+");
            System.out.println("|        MENU         |");
            System.out.println("+---------------------+");
            System.out.println("| OPCION | DESCRIPCION|");
            System.out.println("+---------------------+");
            System.out.println("|   1    | Registrar  |");
            System.out.println("|   2    | Modificar  |");
            System.out.println("|   3    | Eliminar   |");
            System.out.println("|   4    | Consultar  |");
            System.out.println("|   5    | Salir      |");
            System.out.println("+---------------------+");
            System.out.print("Elige una opción: ");
                int option = scanner.nextInt();

            switch (option) {
                case 1:
                System.out.println("+---------------------+");
                System.out.println("|   MENU REGISTRAR    |");
                System.out.println("+---------------------+");
                System.out.println("| OPCION | DESCRIPCION|");
                System.out.println("+---------------------+");
                System.out.println("|   1    | Empleado   |");
                System.out.println("|   2    | Visitante  |");
                System.out.println("|   3    | Animal     |");
                System.out.println("|   4    | Visita     |");
                System.out.println("+---------------------+");
                System.out.print("Elige una opción: ");
                int optionRegister = scanner.nextInt();

                    switch (optionRegister) {
                        case 1:
                            zoo.addEmployee();
                            break;
                        case 2:
                            zoo.addVisitor();
                            break;
                        case 3:
                            zoo.addAnimal();
                            break;
                        case 4:
                            zoo.registerVisit();
                            break;
                    }

                    break;
                case 2:
                
                System.out.println("+---------------------+");
                System.out.println("|   MENU MODIFICAR    |");
                System.out.println("+---------------------+");
                System.out.println("| OPCION | DESCRIPCION|");
                System.out.println("+---------------------+");
                System.out.println("|   1    | Empleado   |");
                System.out.println("|   2    | Visitante  |");
                System.out.println("|   3    | Animal     |");
                System.out.println("+---------------------+");
                System.out.print("Elige una opción: ");
                int optionModify = scanner.nextInt();

                    switch (optionModify) {
                        case 1:
                            zoo.modifyEmployee();
                            break;
                        case 2:
                            zoo.modifyVisitor();
                            break;
                        case 3:
                        System.out.println("Metodo modificar animal");
                            break;
                    }

                    break;
                case 3:
                System.out.println("xdx");
                    break;
                case 4:
                System.out.println("xd");
                    break;
                case 5:
                System.out.println("Terminando sesion...");
                    System.exit(0);
                    break;
            }
        } while(true);
    }
}