
package Binary_Tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Bottom_View_Binary_Tree {
   static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

     static List<Integer> bottomView(Node root) {

        List<Integer> ans = new ArrayList<>();

        if(root == null) {
            return ans;
        }

        Map<Integer, Integer> mpp = new TreeMap<>();

        Queue<Pair<Node, Integer>> q = new LinkedList<>();


        q.add(new Pair<>(root, 0));

        while(!q.isEmpty()) {

            Pair<Node, Integer> pair = q.poll();
            Node node = pair.getKey();
            int line = pair.getValue();
//override the previous value
            mpp.put(line, node.data);

            if(node.left != null) {

                q.add(new Pair<>(node.left, line - 1));
            }

            if(node.right != null) {
                q.add(new Pair<>(node.right, line + 1));
            }
        }

        for(Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}
