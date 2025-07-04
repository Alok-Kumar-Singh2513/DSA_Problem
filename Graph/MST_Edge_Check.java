package Graph;
import java.util.*;

public class MST_Edge_Check {
    static class Edge {
        int u, v, w, idx;

        Edge(int u, int v, int w, int idx) {
            this.u = u;
            this.v = v;
            this.w = w;
            this.idx = idx;
        }
      }
    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return;
            if (rank[px] < rank[py]) parent[px] = py;
            else {
                parent[py] = px;
                if (rank[px] == rank[py]) rank[px]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            edges.add(new Edge(u, v, w, i));
        }

        edges.sort(Comparator.comparingInt(e -> e.w));
        String[] result = new String[m];
        DSU dsu = new DSU(n);

        int i = 0;
        while (i < m) {
            int j = i;
            List<Edge> batch = new ArrayList<>();
            while (j < m && edges.get(j).w == edges.get(i).w) {
                batch.add(edges.get(j));
                j++;
            }

            // First pass: check which can be added (no immediate union)
            List<Edge> toUnion = new ArrayList<>();
            for (Edge e : batch) {
                int u = e.u, v = e.v;
                if (dsu.find(u) != dsu.find(v)) {
                    result[e.idx] = "YES";
                    toUnion.add(e);
                } else {
                    result[e.idx] = "NO";
                }
            }

            // Second pass: perform unions
            for (Edge e : toUnion) {
                dsu.union(e.u, e.v);
            }

            i = j;
        }

        for (String ans : result) {
            System.out.println(ans);
        }
        sc.close();
    }
}









