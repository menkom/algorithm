package info.mastera.search;

import info.mastera.util.Node;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BreadthFirstSearch {

    Map<Node, Set<Node>> source;

    public BreadthFirstSearch(Map<Node, Set<Node>> source) {
        this.source = source;
        System.out.println("source.size=" + source.size() + " for " + this.getClass().getSimpleName());
        System.out.println(sourceToString());
    }

    public final Node search() {
        return measure(this::find);
    }

    protected Node find() {
        var startNode = source.keySet()
                .stream()
                .filter(node -> node.getName().equals("you"))
                .findFirst()
                .orElseThrow();
        var currentQueue = new ArrayDeque<>(source.get(startNode));
        return find(currentQueue, new HashSet<Node>(Set.of(startNode)));
    }

    private Node measure(Supplier<Node> method) {
        var eventStart = LocalDateTime.now();
        try {
            return method.get();
        } finally {
            System.out.println("Search took " + ChronoUnit.MILLIS.between(eventStart, LocalDateTime.now()));
        }
    }

    private String sourceToString() {
        return source.keySet().stream()
                .map(key -> "{" + key + "::" + source.get(key) + "}")
                .collect(Collectors.joining(",", "[", "]"));
    }

    private Node find(Queue<Node> source, Set<Node> exclude) {
        if (source.isEmpty()) {
            return null;
        } else {
            var current = source.poll();
            if (current.isCondition()) {
                return current;
            } else {
                exclude.add(current);
                var newNodes = new HashSet<>(this.source.get(current));
                newNodes.removeAll(exclude);
                source.addAll(newNodes);
                return find(source, exclude);
            }
        }
    }
}
