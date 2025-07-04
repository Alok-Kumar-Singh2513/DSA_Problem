package Stack;

import java.util.Stack;

public class o735_Asteroid_Collision {
  public int[] asteroidCollision(int[] asteroids) {
         Stack<Integer> stack = new Stack<>();
          for (int asteroid : asteroids) {
              if (asteroid > 0 || stack.isEmpty() || stack.peek() < 0) {
                  stack.push(asteroid);
              } else {
                  while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                      stack.pop();
                  }
                  if (!stack.isEmpty() && stack.peek() == Math.abs(asteroid)) {
                      stack.pop();
                  } else if (stack.isEmpty() || stack.peek() < 0) {
                      stack.push(asteroid);
                  }
              }
          }
          int[] result = new int[stack.size()];
          for (int i = stack.size() - 1; i >= 0; i--) {
              result[i] = stack.pop();
          }
          return result;
  }

//   Second way
public static int[] asteroidCollision2(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for (int asteroid : asteroids) {
        if(asteroid>0){
            stack.push(asteroid);
        }else{
            while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(asteroid)){
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek()==Math.abs(asteroid)){
                stack.pop();
            }else if(stack.isEmpty() || stack.peek()<0){
                stack.push(asteroid);
            }
        }
    }
    int[] result = new int[stack.size()];
    for (int i = stack.size() - 1; i >= 0; i--) {
        result[i] = stack.pop();
    }
    return result;
}

}
