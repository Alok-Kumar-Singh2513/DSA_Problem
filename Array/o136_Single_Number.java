public class o136_Single_Number {
  public static int singleNumber(int[] a) {
    int ans=0;
   for (int i=0;i<a.length;i++){
       ans = (ans ^ a[i] );
   }
   return ans;
 
}
public static void main(String[] args) {
  int []arr={1,23,4,56,23,4,56};
  System.out.println(singleNumber(arr)); // Output: 1
}
}
