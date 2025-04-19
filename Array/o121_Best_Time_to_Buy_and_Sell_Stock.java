public class o121_Best_Time_to_Buy_and_Sell_Stock {
  public int maxProfit(int[] a) {
    int maxiProfit=0;
   int minSold=a[0];
   for (int i=0;i<a.length;i++){
       minSold=Math.min(minSold,a[i]);
       int profit=a[i]-minSold;
       maxiProfit=Math.max(maxiProfit,profit);
   }
   return maxiProfit;
}
public static void main(String[] args) {
  o121_Best_Time_to_Buy_and_Sell_Stock obj = new o121_Best_Time_to_Buy_and_Sell_Stock();
  int[] prices = {7, 1, 5, 3, 6, 4};
  System.out.println(obj.maxProfit(prices)); 
}
}
