package phonebook.service;

import phonebook.entity.Contact;
import java.util.ArrayList;

// ========== ATRIBUTOS ==========
// Gestión de contactos y capacidad máxima de la agenda telefónica
public class PhoneBook {

    private static final int DEFAULT_CAPACITY = 10;

    // Capacidad máxima permitida
    private final int maximumCapacity;

    // Lista donde se guardan los contactos
    private ArrayList<Contact> contacts;

    // ========== CONSTRUCTOR ==========
    // Crear agenda de 10 contactos
    public PhoneBook() {
        this(DEFAULT_CAPACITY);
    } // PhoneBook

    // ========== CONSTRUCTOR ==========
    // Permite crear una agenda con capacidad personalizada
    public PhoneBook(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.contacts = new ArrayList<>();
    } // PhoneBook

    // ========== MÉTODO agendaFull() ==========
    // Verificar si la agenda llegó a su límite
    public boolean agendaFull() {
        return contacts.size() >= maximumCapacity;
    } // agendaFull

    // ========== MÉTODO freeSpaces() ==========
    // Calcula cuántos espacios quedan disponibles
    public int freeSpaces() {
        return maximumCapacity - contacts.size();
    } // freeSpaces

    // ========== MÉTODO existsContact() ==========
    // Verificar si un contacto ya existe en la agenda
    public boolean existsContact(Contact contact) {
        return contacts.contains(contact);
    } // existsContact

    // ========== MÉTODO addContact() ==========
    // Agregar un contacto validando capacidad y duplicados
    public void addContact(Contact contact) {

        // Valida si ya no hay espacio disponible
        if (agendaFull()) {
            System.out.println("La agenda telefónica está llena.");
            return;
        }

        // Valida si el contacto ya existe
        if (existsContact(contact)) {
            System.out.println("El contacto ya existe.");
            return;
        }

        // Agrega el contacto a la lista
        contacts.add(contact);

        System.out.println("Contacto añadido correctamente.");

    } // addContact

} // class PhoneBook