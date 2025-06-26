package library;

public class LibraryApp {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addBook(new Book("9780134685991", "Effective Java", "Joshua Bloch"));
        lib.addBook(new Book("9780132350884", "Clean Code", "Robert Martin"));
        lib.addBook(new Book("9780596009205", "Head First Design Patterns", "Eric Freeman"));

        lib.registerUser(new User(1, "Alice"));
        lib.registerUser(new User(2, "Bob"));

        System.out.println("Initial catalog:");
        lib.listBooks();

        lib.issueBook("9780134685991", 1);
        System.out.println("\nAfter issuing 'Effective Java' to Alice:");
        lib.listBooks();

        lib.returnBook("9780134685991", 1);
        System.out.println("\nAfter return:");
        lib.listBooks();
    }
}
