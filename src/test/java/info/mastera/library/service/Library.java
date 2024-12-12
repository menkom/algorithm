package info.mastera.library.service;

import info.mastera.library.model.Book;
import info.mastera.library.model.BookStatus;
import info.mastera.library.model.User;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Library {

    ConcurrentHashMap<String, Book> books = new ConcurrentHashMap<>();

    ConcurrentHashMap<String, Queue<User>> waitlist = new ConcurrentHashMap<>();

    public void addBook(String name) {
        books.put(name, new Book(name));
    }

    public synchronized void requestBook(String name, User user) {
        var book = books.get(name);
        if (book != null) {
            if (book.status == BookStatus.IN_HANDS) {
                var waiting = waitlist.getOrDefault(name, new ArrayDeque<>(10));

                if (waiting.size() <= 10) {
                    waiting.add(user);
                    waitlist.put(name, waiting);
                }
            } else {
                book.status = BookStatus.IN_HANDS;
            }
        }
    }

    public synchronized void returnBook(String name) {
        var book = books.get(name);
        if (book != null) {
            var waiting = waitlist.getOrDefault(name, new ArrayDeque<>());
            if (waiting.isEmpty()) {
                book.status = BookStatus.AVAILABLE;
            } else {
                waiting.poll();
            }
        } else {
            System.out.println("Not our book");
        }
    }

    @Override
    public String toString() {
        return "Books{%s}:%n%s %nWaitlist{%s}:%n%s"
                .formatted(
                        books.size(),
                        books.entrySet().stream()
                                .map(entry -> entry.getKey() + ":" + entry.getValue())
                                .collect(Collectors.joining("\n")),
                        waitlist.size(),
                        waitlist.entrySet().stream()
                                .map(entry -> entry.getKey() + ":" + entry.getValue().stream()
                                        .map(user -> user.name)
                                        .collect(Collectors.joining(",", "{", "}")))
                                .collect(Collectors.joining("\n"))
                );
    }
}
