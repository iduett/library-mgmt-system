import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Irene Duett
 * CEN 3024C
 * 05/18/2024
 * Book Class = a unique book in the library system
 * Each book is defined by a unique ID
 * A unique ID contains the book title and author
*/

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    @Override
public String toString() {
        return id + " " + title + " " + author;
}
}
/**
 * Irene Duett
 * CEN 3024C
 * 05/18/2024
 * Library Class = used to manage the book collection
 * Adds a new book, removes existing book selecting by ID
 * Also displays books in a list
 */
class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    /**
     * addABook Method
     * Used to add a new book
     *arguments = id (int), title(String), author (String)
     * return = nothing
     */

    public void addBook(int id, String title, String author) {
    books.add(new Book(id, title, author));
    }

    /**
     * removeBook Method
     * Used to remove a book
     * arguments = bookID (int)
     * return = nothing
     */
    public void removeBook(int BookId) {
        books.removeIf(book -> book.getId() == BookId);
    }

    /**
     * listBooks Method
     * used to list the books in the system
     * arguments = nothing
     * return = nothing
     */
    public void listAllBooks(){
        if (books.isEmpty()) {
            System.out.println("There are no books");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
    /**
     * Irene Duett
     * CEN 3024C
     * 05/18/2024
     * Main Class = runs the program
     */
    public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true){
            System.out.println("Press 1 to add a book ");
            System.out.println("Press 2 to remove a book ");
            System.out.println("Press 3 to list all books ");
            System.out.println("Press 4 to exit ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter id : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter title : ");
                    String title = scanner.nextLine();
                    System.out.println("Enter author : ");
                    String author = scanner.nextLine();
                    library.addBook(id, title, author);
                    break;

                    case 2:
                        System.out.print("Enter id : ");
                        int BookId = scanner.nextInt();
                        library.removeBook(BookId);
                        break;
                        case 3:
                            library.listAllBooks();
                            break;
                            case 4:
                                System.out.println("Goodbye!");
                                scanner.close();
                                System.exit(0);
                default:
                    System.out.println("Invalid. Try again.");
            }


        }
        }
    }
}