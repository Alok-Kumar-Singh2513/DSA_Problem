package Greedy;

import java.util.*;

public class o1561_Maximum_Number_of_Coins_You_Can_Get {
   public static int maxCoins(int[] piles) {
        int n= piles.length;
        Arrays.sort(piles);
        int result=0;
        for(int i=n/3;i<n;i+=2){
            result+= piles[i];
        }
        return result;
    }

}
