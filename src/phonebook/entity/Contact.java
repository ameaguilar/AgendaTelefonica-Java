package phonebook.entity;

import java.util.Locale;
import java.util.Objects;

public class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Constructor
    public Contact(String firstName, String lastName, String phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        this.phoneNumber = phoneNumber;
    }

    // Devuelve el nombre
    public String getFirstName() {
        return firstName;
    }

    // Establece el nombre y evita valores nulos o vacíos
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacio."
            );
        }
        this.firstName = firstName.trim();
    }

    // Devuelve el apellido
    public String getLastName() {
        return lastName;
    }

    // Establece el apellido y evita valores nulos o vacíos
    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El apellido no puede estar vacio."
            );
        }
        this.lastName = lastName.trim();
    }

    // Devuelve el teléfono
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Modifica el teléfono sin validar su formato
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Compara contactos por nombre y apellido, ignorando mayúsculas
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Contact)) {
            return false;
        }

        Contact other = (Contact) obj;

        return firstName.equalsIgnoreCase(other.firstName)
                && lastName.equalsIgnoreCase(other.lastName);
    }

    // Genera un código hash coherente con equals()
    @Override
    public int hashCode() {
        return Objects.hash(
                firstName.toLowerCase(Locale.ROOT),
                lastName.toLowerCase(Locale.ROOT)
        );
    }
} // class contact
