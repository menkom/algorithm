package info.mastera.generation;

import info.mastera.util.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GraphGeneration {

    public static Map<Node, Set<Node>> generateNoResult() {
        var graph = new HashMap<Node, Set<Node>>();
        graph.put(new Node("you"), Set.of(new Node("alice"), new Node("bob"), new Node("claire")));
        graph.put(new Node("bob"), Set.of(new Node("anuj"), new Node("peggy")));
        graph.put(new Node("alice"), Set.of(new Node("peggy")));
        graph.put(new Node("claire"), Set.of(new Node("thom"), new Node("jonny")));
        graph.put(new Node("anuj"), Set.of());
        graph.put(new Node("peggy"), Set.of());
        graph.put(new Node("thom"), Set.of());
        graph.put(new Node("jonny"), Set.of());
        return graph;
    }

    public static Map<Node, Set<Node>> generateWithResult() {
        var graph = generateNoResult();
        graph.put(new Node("claire"), Set.of(new Node("thom").setCondition(true), new Node("jonny")));
        return graph;
    }

    public static Map<Node, Set<Node>> generateLoop() {
        var graph = new HashMap<Node, Set<Node>>();
        graph.put(new Node("you"), Set.of(new Node("alice")));
        graph.put(new Node("alice"), Set.of(new Node("you")));
        return graph;
    }
}
