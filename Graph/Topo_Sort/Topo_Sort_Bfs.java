package Graph.Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Topo_Sort_Bfs {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        int[] inDegree = new int[V];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            inDegree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            res.add(u);
            for (int v : g.get(u)) {
                // when inDegree of v becomes 0, add it to the queue
                // this means all its dependencies are resolved
                if (--inDegree[v] == 0) {
                    q.add(v);
                }
            }
        }
        return res;
    }

    // by using DFS
    public static ArrayList<Integer> topoSortDFS(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < V; i++)
            g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
        }

        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(g, vis, res, i);
            }
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> g, boolean[] vis, ArrayList<Integer> res, int u) {
        vis[u] = true;
        for (int v : g.get(u)) {
            if (!vis[v]) {
                dfs(g, vis, res, v);
            }
        }
        res.add(u);
    }
}
