package phonebook.entity;
import

/** Represents a person stored in the phone book. */
public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    //constructor
        public Contact(String firstName, String lastName, String phoneNumber) {
            if (firstName != null && !firstName.trim().isEmpty()) {
                this.firstName = firstName.trim();
            }
            if (lastName != null && !lastName.trim().isEmpty()) {
                this.lastName = lastName.trim();
            }
            this.phoneNumber = phoneNumber;
        } // constructor Contact

        public String getFirstName() {
            return firstName;
        } // getFirstName

        public void setFirstName(String firstName) {
            if (firstName != null && !firstName.trim().isEmpty()) {
                this.firstName = firstName.trim();
            }
        } //setFirstName

        public String getLastName() {
            return lastName;
        } // getLastName

        public void setLastName(String lastName) {
            if (lastName != null && !lastName.trim().isEmpty()) {
                this.lastName = lastName.trim();
            }
        } //setLastName

        public String getPhoneNumber() {
            return phoneNumber;
        } //getPhoneNumber

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        } // setPhoneNumber

}//class Contact
