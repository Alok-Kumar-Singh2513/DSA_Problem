package String;
// Description: Given a character array chars, compress it using the following algorithm:
// Begin with an empty string s. For each group of consecutive repeating characters in chars, add the character to s, followed by the number of repetitions of that character. The compressed string should be stored in the same array chars. The length after compression must be the same as or smaller than the original array. Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
// Return the new length of the array after compression. Do not use any extra space for another array. The input array should be modified in-place with O(1) extra memory.

public class o443_String_Compression {
  public int compress(char[] chars) {
    char currentChar = chars[0];
    int count = 1;
    int index = 0;
    for(int i=1;i<chars.length;i++){
      if(chars[i]==currentChar){
        count++;
      }else{
        chars[index++]=currentChar;
        // like count=10,count=455, count=1000
        if(count>1){
          String count_str = String.valueOf(count);
          for (char ch : count_str.toCharArray()) {
              chars[index] = ch;
              index++;
          }
        }
      }
    }
    return index;
  }
}
