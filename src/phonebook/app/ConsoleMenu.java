package phonebook.app;
import java.util.Scanner;


public class ConsoleMenu {

    private Scanner sc; //se declara sc como atributo para poder ser utilizado en varios metodos

    private ConsoleMenu() {

        sc = new Scanner(System.in);

    }// consoleMenu

    private int readOption() {

        while(!sc.hasNextInt()){
            System.out.println("Invalid input. Enter a number");
            sc.next();
            System.out.println("Choose an option: ");
        }

        int option = sc.nextInt();
        sc.nextLine();
        return option;

    } // metodo que lee la opcion ingresada por el escaner

    private void showMenu () {

        System.out.println("====== PHONE BOOK ======");
        System.out.println("1.- Add contact");
        System.out.println("2.- Check if contact exist");
        System.out.println("3.- List contacts");
        System.out.println("4.- Search contact");
        System.out.println("5.- Delete contact");
        System.out.println("6.- Modify phone selected");
        System.out.println("7.- Check if phone book is full");
        System.out.println("8.- Check available spaces");
        System.out.println("9.- Exit");
        System.out.println("Choos an option: ");

    } // metodo que muetra las opciones disponibles

    public void start(){
        int option;

        do {
            showMenu();
            option = readOption();

            switch (option) {

                case 1:
                    System.out.println("Add contact selected.");
                    break;

                case 2:
                    System.out.println("Check contact selected");
                    break;

                case 3:
                    System.out.println("List contact selected");
                    break;

                case 4:
                    System.out.println("Search contact selected");
                    break;

                case 5:
                    System.out.println("Delete contact selected");
                    break;

                case 6:
                    System.out.println("Modify phone selected");
                    break;

                case 7:
                    System.out.println("Check if phonebook is full");
                    break;

                case 8:
                    System.out.println("Check available spaces selected");
                    break;

                case 9:
                    System.out.println("Exiting phonebook");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");

            } // switch (opcion)
        } while (option != 0);
    }//metodo que inicia el menu principal de la agenda



} // class consoleMenu


