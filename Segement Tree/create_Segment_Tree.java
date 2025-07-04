public class create_Segment_Tree {

    public static class MinSegmentTree {
        int[] tree;
        int n;

        public MinSegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(arr, 0, 0, n - 1);
        }

        private void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = start + (end - start) / 2;
                build(arr, 2 * node + 1, start, mid);
                build(arr, 2 * node + 2, mid + 1, end);
                tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }

        public int query(int queryL, int queryR) {
            return query(0, 0, n - 1, queryL, queryR);
        }

        private int query(int node, int start, int end, int queryL, int queryR) {
            if (start > queryR || end < queryL) {
                return Integer.MAX_VALUE;
            }
            if (queryL <= start && end <= queryR) {
                return tree[node];
            }
            int mid = start + (end - start) / 2;
            int p1 = query(2 * node + 1, start, mid, queryL, queryR);
            int p2 = query(2 * node + 2, mid + 1, end, queryL, queryR);
            return Math.min(p1, p2);
        }

        public void update(int idx, int val) {
            update(0, 0, n - 1, idx, val);
        }

        private void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = start + (end - start) / 2;
            if (idx <= mid) {
                update(2 * node + 1, start, mid, idx, val);
            } else {
                update(2 * node + 2, mid + 1, end, idx, val);
            }
            tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
        }
    }

    public static class MaxSegmentTree {
        int[] tree;
        int n;

        public MaxSegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(arr, 0, 0, n - 1);
        }

        private void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = start + (end - start) / 2;
                build(arr, 2 * node + 1, start, mid);
                build(arr, 2 * node + 2, mid + 1, end);
                tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }

        public int query(int queryL, int queryR) {
            return query(0, 0, n - 1, queryL, queryR);
        }

        private int query(int node, int start, int end, int queryL, int queryR) {
            if (start > queryR || end < queryL) {
                return Integer.MIN_VALUE;
            }
            if (queryL <= start && end <= queryR) {
                return tree[node];
            }
            int mid = start + (end - start) / 2;
            int p1 = query(2 * node + 1, start, mid, queryL, queryR);
            int p2 = query(2 * node + 2, mid + 1, end, queryL, queryR);
            return Math.max(p1, p2);
        }

        public void update(int idx, int val) {
            update(0, 0, n - 1, idx, val);
        }

        private void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = start + (end - start) / 2;
            if (idx <= mid) {
                update(2 * node + 1, start, mid, idx, val);
            } else {
                update(2 * node + 2, mid + 1, end, idx, val);
            }
            tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
        }
    }

    public static class SumSegmentTree {
        long[] tree;
        int n;

        public SumSegmentTree(int[] arr) {
            n = arr.length;
            tree = new long[4 * n];
            build(arr, 0, 0, n - 1);
        }

        private void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = start + (end - start) / 2;
                build(arr, 2 * node + 1, start, mid);
                build(arr, 2 * node + 2, mid + 1, end);
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }

        public long query(int queryL, int queryR) {
            return query(0, 0, n - 1, queryL, queryR);
        }

        private long query(int node, int start, int end, int queryL, int queryR) {
            if (start > queryR || end < queryL) {
                return 0L;
            }
            if (queryL <= start && end <= queryR) {
                return tree[node];
            }
            int mid = start + (end - start) / 2;
            long p1 = query(2 * node + 1, start, mid, queryL, queryR);
            long p2 = query(2 * node + 2, mid + 1, end, queryL, queryR);
            return p1 + p2;
        }

        public void update(int idx, int val) {
            update(0, 0, n - 1, idx, val);
        }

        private void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = start + (end - start) / 2;
            if (idx <= mid) {
                update(2 * node + 1, start, mid, idx, val);
            } else {
                update(2 * node + 2, mid + 1, end, idx, val);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public static class XORSegmentTree {
        int[] tree;
        int n;

        public XORSegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(arr, 0, 0, n - 1);
        }

        private void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = start + (end - start) / 2;
                build(arr, 2 * node + 1, start, mid);
                build(arr, 2 * node + 2, mid + 1, end);
                tree[node] = tree[2 * node + 1] ^ tree[2 * node + 2];
            }
        }

        public int query(int queryL, int queryR) {
            return query(0, 0, n - 1, queryL, queryR);
        }

        private int query(int node, int start, int end, int queryL, int intqueryR) {
            if (start > intqueryR || end < queryL) {
                return 0;
            }
            if (queryL <= start && end <= intqueryR) {
                return tree[node];
            }
            int mid = start + (end - start) / 2;
            int p1 = query(2 * node + 1, start, mid, queryL, intqueryR);
            int p2 = query(2 * node + 2, mid + 1, end, queryL, intqueryR);
            return p1 ^ p2;
        }

        public void update(int idx, int val) {
            update(0, 0, n - 1, idx, val);
        }

        private void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = start + (end - start) / 2;
            if (idx <= mid) {
                update(2 * node + 1, start, mid, idx, val);
            } else {
                update(2 * node + 2, mid + 1, end, idx, val);
            }
            tree[node] = tree[2 * node + 1] ^ tree[2 * node + 2];
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 7, 9, 11};
        
        System.out.println("Original Array: " + java.util.Arrays.toString(arr));
        System.out.println("----------------------------------------");

        System.out.println("Min Segment Tree:");
        MinSegmentTree minTree = new MinSegmentTree(arr);
        System.out.println("Min in range [0, 5]: " + minTree.query(0, 5));
        System.out.println("Min in range [2, 4]: " + minTree.query(2, 4));
        System.out.println("Updating arr[2] to 10...");
        minTree.update(2, 10);
        System.out.println("Min in range [0, 5] after update: " + minTree.query(0, 5));
        System.out.println("Min in range [2, 4] after update: " + minTree.query(2, 4));
        System.out.println("----------------------------------------");


        System.out.println("Max Segment Tree:");
        MaxSegmentTree maxTree = new MaxSegmentTree(arr);
        System.out.println("Max in range [0, 5]: " + maxTree.query(0, 5));
        System.out.println("Max in range [0, 2]: " + maxTree.query(0, 2));
        System.out.println("Updating arr[0] to 15...");
        maxTree.update(0, 15);
        System.out.println("Max in range [0, 5] after update: " + maxTree.query(0, 5));
        System.out.println("Max in range [0, 2] after update: " + maxTree.query(0, 2));
        System.out.println("----------------------------------------");


        System.out.println("Sum Segment Tree:");
        SumSegmentTree sumTree = new SumSegmentTree(arr);
        System.out.println("Sum in range [0, 5]: " + sumTree.query(0, 5));
        System.out.println("Sum in range [1, 3]: " + sumTree.query(1, 3));
        System.out.println("Updating arr[3] to 0...");
        sumTree.update(3, 0);
        System.out.println("Sum in range [0, 5] after update: " + sumTree.query(0, 5));
        System.out.println("Sum in range [1, 3] after update: " + sumTree.query(1, 3));
        System.out.println("----------------------------------------");


        System.out.println("XOR Segment Tree (Array: " + java.util.Arrays.toString(new int[]{5, 3, 8, 1, 6}) + "):");
        XORSegmentTree xorTree = new XORSegmentTree(new int[]{5, 3, 8, 1, 6});
        System.out.println("XOR in range [0, 4]: " + xorTree.query(0, 4));
        System.out.println("XOR in range [0, 1]: " + xorTree.query(0, 1));
        System.out.println("Updating xorArr[2] to 2 (10)...");
        xorTree.update(2, 2);
        System.out.println("XOR in range [0, 4] after update: " + xorTree.query(0, 4));
        System.out.println("XOR in range [0, 2] after update: " + xorTree.query(0, 2));
        System.out.println("----------------------------------------");
        
        System.out.println("Average (conceptual):");
        System.out.println("Average in range [1, 3] for sumTree: " + (double)sumTree.query(1, 3) / (3 - 1 + 1));
    }
}