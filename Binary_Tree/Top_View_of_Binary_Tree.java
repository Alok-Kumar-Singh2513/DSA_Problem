package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Top_View_of_Binary_Tree {
  public static class Node {
    int data;
    Node left, right;

    Node(int item) {
      data = item;
      left = right = null;
    }
  }
   static List<Integer> topView(Node root) {
        List<Integer> ans = new ArrayList<>();
        
        if (root == null) {
            return ans;
        }
        
        Map<Integer, Integer> mpp = new TreeMap<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        
        while (!q.isEmpty()) {
            Pair<Node, Integer> pair = q.poll();
            Node node = pair.getKey();
            int line = pair.getValue();
            
            if (!mpp.containsKey(line)) {
                mpp.put(line, node.data);
            }
            
            if (node.left != null) {
                q.add(new Pair<>(node.left, line - 1));
            }
            
            if (node.right != null) {
                q.add(new Pair<>(node.right, line + 1));
            }
        }
        
        for (int value : mpp.values()) {
            ans.add(value);
        }
        
        return ans;
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
}
