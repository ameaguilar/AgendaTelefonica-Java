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

        //Espacios libres
        public int espacioLibres() {
            return maximumCapacity - contacts.size();
        }

        //Listar contactos ordenados alfabéticamente
        public void listarContactos() {
            if (contacts.isEmpty()) {
                System.out.println("La agenda está vacía.");
                return;
            }

            List<Contact> listaOrdenada = new ArrayList<>(contacts);
            Collections.sort(listaOrdenada);

            System.out.println("\n--- LISTA DE CONTACTOS (Orden Alfabético) ---");
            for (Contact c : listaOrdenada) {
                System.out.println(c.getNombre() + " " + c.getApellido() + " - " + c.getTelefono());
            }
            System.out.println("---------------------------------------------");
        }

        //Buscar contacto por nombre y apellido
        public void buscaContacto(String nombre, String apellido) {
            boolean encontrado = false;
            for (Contact c : contacts) {
                if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                    System.out.println("Contacto encontrado -> Teléfono: " + c.getTelefono());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No se ha encontrado un contacto con el nombre: " + nombre + " " + apellido);
            }
        }

        //Eliminar contacto
        public void eliminarContacto(Contact c) {
            if (existeContacto(c)) {
                contacts.remove(c);
                System.out.println("Contacto eliminado exitosamente.");
            } else {
                System.out.println("El contacto que intenta eliminar no existe en la agenda.");
            }
        }

        // 5. Modificar teléfono
        public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
            boolean modificado = false;
            for (Contact c : contacts) {
                if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                    c.setTelefono(nuevoTelefono);
                    System.out.println("Teléfono modificado exitosamente para " + nombre + " " + apellido);
                    modificado = true;
                    break;
                }
            }
            if (!modificado) {
                System.out.println("El contacto no existe, no se pudo modificar el teléfono.");
            }
        }