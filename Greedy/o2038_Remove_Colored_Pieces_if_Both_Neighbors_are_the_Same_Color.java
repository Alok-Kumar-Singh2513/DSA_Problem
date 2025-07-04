package Greedy;

public class o2038_Remove_Colored_Pieces_if_Both_Neighbors_are_the_Same_Color {
   public static boolean winnerOfGame(String colors) {
       int n= colors.length();
        int countA = 0, countB = 0;
        for(int i=1;i<n-1;i++){
            if(colors.charAt(i-1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i+1)){
                if(colors.charAt(i) == 'A'){
                    countA++;
                }else{
                    countB++;
                }
            }
        }
        return countA > countB;
    }
    public static void main(String[] args) {
        System.out.println(winnerOfGame("AAABABB")); // true
        System.out.println(winnerOfGame("AA")); // false
        System.out.println(winnerOfGame("ABBBBBBBAA")); // false
    }
}
