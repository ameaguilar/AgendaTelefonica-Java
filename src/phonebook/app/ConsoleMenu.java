package phonebook.app;

import java.util.Scanner;
import phonebook.entity.Contact;
import phonebook.service.PhoneBook;

public class ConsoleMenu {

    private Scanner sc; //se declara sc como atributo para poder ser utilizado en varios metodos
    private PhoneBook phoneBook = new PhoneBook(); // instancia de Agenda

    public ConsoleMenu() {

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

    public void showMenu () {

        System.out.println("====== PHONE BOOK ======");
        System.out.println("1.- Agregar Contacto");
        System.out.println("2.- Verifica si existe contacto");
        System.out.println("3.- Lista de contactos");
        System.out.println("4.- Buscar contactos");
        System.out.println("5.- Eliminar contacto");
        System.out.println("6.- Modificar número de teléfono");
        System.out.println("7.- Verificar si agenda está llena");
        System.out.println("8.- Verificar espacios disponibles");
        System.out.println("0.- Salir");
        System.out.print("Elige una opción: ");

    } // metodo que muetra las opciones disponibles

    public void start(){
        int option;

        do {
            showMenu();
            option = readOption();

            switch (option) {

                case 1: {
                    System.out.print("Nombre: ");
                    String firstName = sc.nextLine();

                    System.out.print("Apellido: ");
                    String lastName = sc.nextLine();

                    System.out.print("Teléfono: ");
                    String phoneNumber = sc.nextLine();

                    Contact contact = new Contact(firstName, lastName, phoneNumber);
                    phoneBook.addContact(contact);
                    break;
                }
                case 2: {
                    System.out.println("Verifica contacto seleccionado");
                    System.out.print("\n Nombre: ");
                    String firstName = sc.nextLine();

                    System.out.print("Apellido: ");
                    String lastName = sc.nextLine();
                    Contact contact = new Contact(firstName, lastName, "");
                    System.out.print(phoneBook.existsContact(contact)
                                    ? "El contacto existe"
                                    : "El contacto no existe");
                    break;
                }
                case 3: {
                    System.out.println("Lista de contactos seleccionados");
                    phoneBook.listarContactos();
                    break;
                }
                case 4: {
                    System.out.println("Buscar contacto seleccionado");
                    System.out.print("Nombre: ");
                    String firstName = sc.nextLine();

                    System.out.print("Apellido: ");
                    String lastName = sc.nextLine();

                    phoneBook.buscaContacto(firstName,lastName);
                    break;
                }
                case 5: {
                    System.out.println("Eliminar contacto seleccionado");
                    System.out.print("Nombre: ");
                    String firstName = sc.nextLine();

                    System.out.print("Apellido: ");
                    String lastName = sc.nextLine();
                    Contact contact = new Contact(firstName, lastName, "");
                    phoneBook.eliminarContacto(contact);
                    break;
                }
                case 6: {
                    System.out.println("Modifica teléfono de contacto");
                    System.out.print("Nombre: ");
                    String firstName = sc.nextLine();

                    System.out.print("Apellido: ");
                    String lastName = sc.nextLine();

                    System.out.print("Nuevo teléfono: ");
                    String newPhoneNumber = sc.nextLine();

                    phoneBook.modificarTelefono(firstName, lastName, newPhoneNumber);
                    break;
                }
                case 7: {
                    System.out.println("Revisa agenda llena");
                    System.out.println(phoneBook.agendaFull()
                                        ? "La agenda está llena"
                                        : "La agenda aún tiene espacio");
                    break;
                }
                case 8:
                    System.out.println("Espacio disponible" + phoneBook.freeSpaces());
                    break;

                case 0:
                    System.out.println("Salir de agenda");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo");

            } // switch (opcion)
        } while (option != 0);
    }//metodo que inicia el menu principal de la agenda



} // class consoleMenu


