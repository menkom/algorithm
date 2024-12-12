package info.mastera.library.model;

public class Book {

    //unique per book
    public String name;
    public BookStatus status;

    public Book(String name){
        this.name = name;
        this.status = BookStatus.AVAILABLE;
    }

    @Override
    public String toString() {
        return "["+status+"]"+name;
    }
}
