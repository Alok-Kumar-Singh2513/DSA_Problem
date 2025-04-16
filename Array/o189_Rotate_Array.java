public class o189_Rotate_Array {
  public static void rotate(int[] nums,int  k){
    int n=nums.length;
    k=k%n;
    if(k==0)return;

    int temp[]=new int[k];
    for(int i=0;i<k;i++){
      temp[i]=nums[n-k+i];
    }

    for(int i=n-1;i>=k;i--){
      nums[i]=nums[i-k];
    }

    for(int i=0;i<k;i++){
      nums[i]=temp[i];
    }

  }

  // second method by reverse
  public static void reverse(int[] arr,int start,int end){
    while (start<=end) {
      int temp=arr[start];
      arr[start]=arr[end];
      arr[end]=temp;
      start++;
      end--;
    }
  }
  public static void rotate2(int[] nums,int  k){
    int n=nums.length;
    reverse(nums,0,n-k-1);
    reverse(nums,n-k, n-1);
    reverse(nums, 0, n-1);


  }
  public static void main(String[] args) {
    
  }
}
