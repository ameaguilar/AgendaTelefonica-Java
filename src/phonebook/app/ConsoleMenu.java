package phonebook.app;
import java.util.Scanner;


public class ConsoleMenu {

    private Scanner sc; //se declara sc como atributo para poder ser utilizado en varios metodos

    private ConsoleMenu() {

        sc = new Scanner(System.in);

    }// consoleMenu

    private int readOption() {

        while(!sc.hasNextInt()){
            System.out.println("Entrada no válida, ingresa un número");
            sc.next();
            System.out.println("Elige una opción: ");
        }

        int option = sc.nextInt();
        sc.nextLine();
        return option;

    } // metodo que lee la opcion ingresada por el escaner

    private void showMenu () {

        System.out.println("====== PHONE BOOK ======");
        System.out.println("1.- Agregar Contacto");
        System.out.println("2.- Verifica si existe contacto");
        System.out.println("3.- Lista de contactos");
        System.out.println("4.- Buscar contactos");
        System.out.println("5.- Eliminar contacto");
        System.out.println("6.- Modificar número de teléfono");
        System.out.println("7.- Verificar si agenda está llena");
        System.out.println("8.- Verificar espacios disponibles");
        System.out.println("9.- Salir");
        System.out.println("Elige una opción: ");

    } // metodo que muetra las opciones disponibles

    public void start(){
        int option;

        do {
            showMenu();
            option = readOption();

            switch (option) {

                case 1:
                    System.out.println("Agregar contacto seleccionado.");
                    break;

                case 2:
                    System.out.println("Verifica contacto seleccionado");
                    break;

                case 3:
                    System.out.println("Lista de contactos seleccionados");
                    break;

                case 4:
                    System.out.println("Buscar contacto seleccionado");
                    break;

                case 5:
                    System.out.println("Eliminar contacto seleccionado");
                    break;

                case 6:
                    System.out.println("Modifica teléfono de contacto");
                    break;

                case 7:
                    System.out.println("Revisa agenda llena");
                    break;

                case 8:
                    System.out.println("Revisa espacio en agenda disponible");
                    break;

                case 9:
                    System.out.println("Salir de agenda");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo");

            } // switch (opcion)
        } while (option != 0);
    }//metodo que inicia el menu principal de la agenda



} // class consoleMenu


