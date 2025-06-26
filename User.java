package library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private final int id;
    private final String name;
    private final List<Book> borrowed = new ArrayList<>();

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<Book> getBorrowed() { return Collections.unmodifiableList(borrowed); }

    protected void borrow(Book book) { borrowed.add(book); }
    protected void giveBack(Book book) { borrowed.remove(book); }

    @Override
    public String toString() {
        return String.format("%d - %s (borrowed %d book(s))", id, name, borrowed.size());
    }
}
