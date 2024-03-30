import java.util.Scanner;

public class ZooSystem {
    private final String PASSWORD = "ZooManager";
    private Scanner scanner = new Scanner(System.in);

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
                System.out.println("xd");
                    break;
                case 2:
                System.out.println("xd");
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