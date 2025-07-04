import java.util.Stack;
public class Killer_Monster {
    public static String killerMonster(int[] strength) {
        int n = strength.length;
        if (n == 0) return "";
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int curr = strength[i];

            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }
            stack.push(curr);
            sb.append(stack.size()).append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        int[] strength = {3, 0, 3, 4, 1};
        String result = killerMonster(strength);
        System.out.println();
        System.out.println(result);
    }
}
