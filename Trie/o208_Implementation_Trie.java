package Trie;

public class o208_Implementation_Trie {
    public static class Node {
        Node[] trieNode = new Node[26];
        boolean end = false; 
    }

    private  Node root;

    // Constructor
    public o208_Implementation_Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.trieNode[index] == null) {
                node.trieNode[index] = new Node();
            }
            node = node.trieNode[index];
        }
        node.end = true; // mark end of word
    }

    public boolean search(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.trieNode[index] == null) {
                return false;
            }
            node = node.trieNode[index];
        }
        return node.end;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.trieNode[index] == null) {
                return false;
            }
            node = node.trieNode[index];
        }
        return true;
    }
    public  boolean  delete(String word){
        Node node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.trieNode[index] == null) {
                return false; // word not found
            }
            node = node.trieNode[index];
        }
        if (!node.end) {
            return false; // word not found
        }
        node.end = false; // mark as not end of word
        return true; // word deleted successfully
    }

    public String prefix(String word) {
        Node node = root;
        StringBuilder prefix = new StringBuilder();
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.trieNode[index] == null) {
                break; 
            }
            prefix.append(ch);
            node = node.trieNode[index];
        }
        return prefix.toString(); 
    }
}
