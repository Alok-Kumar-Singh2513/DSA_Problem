package String;

public class o1614_Maximum_Nesting_Depth_of_the_Parentheses {
   public static int maxDepth(String s) {
        
    }
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        int result = maxDepth(s);
        System.out.println("Maximum nesting depth: " + result); // Output: 3

       
    }
}
