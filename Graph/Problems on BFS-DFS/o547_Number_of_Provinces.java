// package Graph;

public class o547_Number_of_Provinces {
 
    public static int findCircleNum(int[][] isConnected) {
      int v=isConnected.length;
      boolean[] visited=new boolean[v];
      int count=0;
      for(int i=0;i<v;i++){
        if(!visited[i]){
          count++;
          dfs(isConnected,visited,i);
        }
      }
      return count;

    }
    public static void dfs(int[][] isConnected,boolean[] visited,int i){
      visited[i]=true;
      for(int j=0;j<isConnected.length;j++){
        if(isConnected[i][j]==1 && !visited[j]){
          dfs(isConnected,visited,j);
        }
      }
    }
    public static void main(String[] args) {
      int[][] isConnected = {
        {1, 1, 0},
        {1, 1, 0},
        {0, 0, 1}
      };
      System.out.println(findCircleNum(isConnected));       
    }
  
}
