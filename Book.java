package library;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private boolean issued;
    private User issuedTo;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return issued; }
    public User getIssuedTo() { return issuedTo; }

    protected void markIssued(User user) {
        this.issued = true;
        this.issuedTo = user;
    }

    protected void markReturned() {
        this.issued = false;
        this.issuedTo = null;
    }

    @Override
    public String toString() {
        return String.format("%s - %s by %s %s",
                isbn, title, author, issued ? "(issued)" : "");
    }
}
