public class linear_Search {
  public static boolean linearSearch(int nums[],int key){
    for(int num:nums){
      if(num==key){
        return true;
      }
    }
    return false;
  }
  public static void main(String[] args) {
    
    int[] ar={1,2,4,5,7,6,4,23,1};
    int key=4;
    boolean result=linearSearch(ar,key);
    if(result){
      System.out.println("Element found in the array");
    }else{
      System.out.println("Element not found in the array");
    }
  }
}
