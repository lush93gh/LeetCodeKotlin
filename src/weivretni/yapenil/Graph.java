package weivretni.yapenil;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    int nNodes;
    List<List<Integer>> adjMap;

    public void init(int nodes) {
        this.nNodes = nodes;
        adjMap = new ArrayList<>(nodes);

        for (int i = 0; i < nodes; i++)
            adjMap.add(new ArrayList<>());
    }

    public void edge(int from, int to) {
        adjMap.get(from).add(to);
    }

    public boolean findCycles() {
        boolean[] visited = new boolean[nNodes];
        boolean[] stack = new boolean[nNodes];

        for (int i = 0; i < nNodes; i++) {
            if (DFS(i, visited, stack)) {
                return true;
            }
        }
        return false;
    }

    boolean DFS(
            int i,
            boolean[] visited,
            boolean[] stack
    ) {
        if (stack[i]) return true;
        if (visited[i]) return false;

        visited[i] = true;
        stack[i] = true;

        List<Integer> children = adjMap.get(i);

        for (Integer c : children) {
            if (DFS(c, visited, stack)) {
                return true;
            }
        }

        stack[i] = false;

        return false;
    }
}
