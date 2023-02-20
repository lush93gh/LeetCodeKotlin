package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 207. Course Schedule
public class M207 {
    List<List<Integer>> adjLists = new ArrayList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            adjLists.add(new LinkedList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjLists.get(prerequisite[1]).add(prerequisite[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, visited, stack))
                return false;
        }

        return true;
    }

    private boolean hasCycle(int i, boolean[] visited, boolean[] stack) {
        if (stack[i]) return true;
        if (visited[i]) return false;
        visited[i] = true;
        stack[i] = true;

        for (Integer j : adjLists.get(i)) {
            if (hasCycle(j, visited, stack))
                return true;
        }

        stack[i] = false;

        return false;
    }
}
