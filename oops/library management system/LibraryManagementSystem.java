import java.util.ArrayList;
import java.util.List;

class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    // Getters and setters
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        isBorrowed = true;
    }

    public void returnBook() {
        isBorrowed = false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}

class Member {
    private int memberId;
    private String name;
    private List<Book> borrowedBooks;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters and setters
    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.borrowBook();
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.returnBook();
    }
}

class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int bookId) {
        books.removeIf(book -> book.getBookId() == bookId);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public List<Book> getAvailableBooks() {
        return books.stream()
                .filter(book -> !book.isBorrowed())
                .toList();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book(1, "jhonwick", "VAMSHI");
        Book book2 = new Book(2, "animals", "SANDEEP");

        library.addBook(book1);
        library.addBook(book2);

        Member member1 = new Member(101, "Alice");
        library.registerMember(member1);

        member1.borrowBook(book1);

        System.out.println("Available books: " + library.getAvailableBooks());
        System.out.println("Borrowed books by Alice: " + member1.getBorrowedBooks());
    }
}