package info.mastera.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DijkstraSearch {

    private final int numberOfNodes;
    private final int[][] adjacencyMatrix;

    public DijkstraSearch(int[][] source, int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        this.adjacencyMatrix = buildAdjacencyMatrix(source, numberOfNodes);
    }

    protected int find(int startNode) {
        int[] pathTime = buildPathTime(startNode);

        return getTime(pathTime);
    }

    private int[][] fill(int dimension) {
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int pos = 0; pos < dimension; pos++) {
                matrix[row][pos] = row == pos ? 0 : Integer.MAX_VALUE;
            }
        }
        return matrix;
    }

    private int[][] buildAdjacencyMatrix(int[][] edges, int dimension) {
        int[][] adjacencyMatrix = fill(dimension);
        for (int[] edge : edges) {
            adjacencyMatrix[edge[0] - 1][edge[1] - 1] = edge[2];
        }
        return adjacencyMatrix;
    }

    private Integer findNext(int[] times, Set<Integer> checked) {
        Integer nextNode = null;
        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < times.length; i++) {
            if (minTime > times[i] && !checked.contains(i)) {
                nextNode = i;
                minTime = times[i];
            }
        }
        return nextNode;
    }

    private int[] buildPathTime(int startNode) {
        int[] pathTime = new int[numberOfNodes];
        Arrays.fill(pathTime, Integer.MAX_VALUE);
        pathTime[startNode - 1] = 0;
        Set<Integer> checked = new HashSet<>(numberOfNodes);

        Integer nextNode = startNode - 1;
        while (nextNode != null) {
            checked.add(nextNode);
            for (int i = 0; i < numberOfNodes; i++) {
                if (!checked.contains(i)) {
                    pathTime[i] = Math.min(pathTime[i], adjacencyMatrix[nextNode][i]);
                }
            }
            nextNode = findNext(pathTime, checked);
        }
        return pathTime;
    }

    private int getTime(int[] pathTime) {
        int delayTime = 0;
        for (Integer time : pathTime) {
            if (time == Integer.MAX_VALUE) {
                return -1;
            } else {
                delayTime += time;
            }
        }
        return delayTime;
    }
}
