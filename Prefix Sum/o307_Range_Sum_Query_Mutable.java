// package Prefix Sum;
//  Segment Tree for Range Sum Query with Update
public class o307_Range_Sum_Query_Mutable {
  private int[] tree;
    private int n;

    public o307_Range_Sum_Query_Mutable(int[] nums) {
        this.n = nums.length;
        this.tree = new int[4 * n];

        if (n > 0) {
            buildTree(nums, 0, 0, n - 1);
        }
    }

    private void buildTree(int[] nums, int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            buildTree(nums, 2 * node + 1, start, mid);
            buildTree(nums, 2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public void update(int index, int val) {
        if (index < 0 || index >= n) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for array of length " + n);
        }
        updateTree(0, 0, n - 1, index, val);
    }

    private void updateTree(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }

        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            updateTree(2 * node + 1, start, mid, idx, val);
        } else {
            updateTree(2 * node + 2, mid + 1, end, idx, val);
        }
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public int sumRange(int left, int right) {
        if (left < 0 || right >= n || left > right) {
            return 0;
        }
        return queryTree(0, 0, n - 1, left, right);
    }

    private int queryTree(int node, int start, int end, int queryL, int queryR) {
        if (queryR < start || queryL > end) {
            return 0;
        }
        if (queryL <= start && end <= queryR) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        int p1 = queryTree(2 * node + 1, start, mid, queryL, queryR);
        int p2 = queryTree(2 * node + 2, mid + 1, end, queryL, queryR);
        return p1 + p2;
    }
}
