package info.mastera.library;

import info.mastera.library.model.User;
import info.mastera.library.service.Library;

/**
 * Implement a Library Book Reservation System
 * Book reservation: If the book is available, users can reserve it. If not, they are put on a waitlist.
 * Return a Book: When a book is returned, it becomes available for reservation or goes to the next user in the waitlist.
 */
public class App {

    private static final Library library = new Library();

    public static void main(String[] args) {
        fillLibrary();
        System.out.println(library);
        System.out.println("+++++++++++++++Library loaded+++++++++++++++++++");
        library.requestBook("Romeo", new User("1"));
        System.out.println(library);
        System.out.println("+++++++++++++++++User 1 served+++++++++++++++++");
        library.requestBook("Romeo", new User("2"));
        System.out.println(library);
        System.out.println("+++++++++++++++++User 2 served+++++++++++++++++");

        library.returnBook("Romeo");
        System.out.println(library);
        System.out.println("+++++++++++++++++User 1 returned book+++++++++++++++++");
    }

    private static void fillLibrary() {
        library.addBook("Romeo");
        library.addBook("Java");
        library.addBook("String");
    }
}
