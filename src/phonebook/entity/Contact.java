package phonebook.entity;
import java.util.Objects;

/** Represents a person stored in the phone book. */
public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    //constructor
        public Contact(String firstName, String lastName, String phoneNumber) {
            setFirstName(firstName);
            setLastName(lastName);
            this.phoneNumber = phoneNumber;
        } // constructor Contact

        public String getFirstName() {
            return firstName;
        } // getFirstName

        public void setFirstName(String firstName) {
            if (firstName == null || firstName.isBlank()) {
                throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
            }
            this.firstName = firstName.trim();
        } //setFirstName

        public String getLastName() {
            return lastName;
        } // getLastName

        public void setLastName(String lastName) {
            if (lastName == null || lastName.isBlank()) {
                throw new IllegalArgumentException("El apellido no puede ser nulo o vacío");
            }
            this.lastName = lastName.trim();
        } //setLastName

        public String getPhoneNumber() {
            return phoneNumber;
        } //getPhoneNumber

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        } // setPhoneNumber

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return firstName.equalsIgnoreCase(contact.firstName)
                && lastName.equalsIgnoreCase(contact.lastName);
    } // equals

    @Override
    public int hashCode() {
        return Objects.hash(
                firstName.toLowerCase(),
                lastName.toLowerCase()
        );
    } // hashCode

}//class Contact
