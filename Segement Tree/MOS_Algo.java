public class MOS_Algo {
  public static int mosAlgo(int[] arr){
    int n= arr.length;
    int blockSize = (int) Math.sqrt(n);
    int[] result=new int[blockSize+1];
   for(int i=0;i<n;i++){
    if(i%blockSize==0){
   blockSize++;
      
    }else{
      result[i/blockSize]+=arr[i];

   }
   return result;

  }

  
}
