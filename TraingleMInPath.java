package Ibm;

import java.util.Arrays;

public class TraingleMInPath {
    public static void main(String[] args){
        int[][] arr={{1},{1,2},{4,7,9},{4,5,6,4}};
        int[][] dp = new int[arr.length][arr.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int res=minPath(0,0,arr,dp);

        System.out.print(res);

    }
    public static  int minPath(int r,int c,int[][] arr,int[][] dp){
      if(r==arr.length-1){
          return arr[r][c];
      }
      if(dp[r][c]!=-1){
          return dp[r][c];
      }
      int left=arr[r][c] +minPath(r+1,c,arr,dp);
      int right=arr[r][c]+minPath(r+1,c+1,arr,dp);
      return  dp[r][c]=Math.min(left,right);

    }

}
