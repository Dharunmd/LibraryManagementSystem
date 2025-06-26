package library;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Book> catalog = new HashMap<>();
    private final Map<Integer, User> members = new HashMap<>();

    public void addBook(Book book) {
        catalog.put(book.getIsbn(), book);
    }

    public void registerUser(User user) {
        members.put(user.getId(), user);
    }

    public boolean issueBook(String isbn, int userId) {
        Book book = catalog.get(isbn);
        User user = members.get(userId);

        if (book == null || user == null || book.isIssued()) return false;

        book.markIssued(user);
        user.borrow(book);

        return true;
    }

    public boolean returnBook(String isbn, int userId) {
        Book book = catalog.get(isbn);
        User user = members.get(userId);

        if (book == null || user == null || !book.isIssued() || book.getIssuedTo().getId() != userId)
            return false;

        book.markReturned();
        user.giveBack(book);
        return true;
    }

    public void listBooks() {
        catalog.values().forEach(System.out::println);
    }
}
