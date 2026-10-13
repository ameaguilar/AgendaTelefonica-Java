package phonebook.service;

/** Manages contacts and the phone book maximum capacity. */
public class PhoneBook {
    private static final int DEFAULT_CAPACITY = 10;

    private final int maximumCapacity;

    public PhoneBook() {
        this(DEFAULT_CAPACITY);
    }

    public PhoneBook(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    // Contact management operations will be implemented here.
}
