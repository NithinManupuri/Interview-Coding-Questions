package Ibm;

import java.util.Arrays;

public class FrogSteps {
    public static void main(String[] args){
        int index=3;
        int[] heights={10,30,20,10};

       int[] dp=new int[heights.length+1];
        Arrays.fill(dp,-1);
        //int res= steps(index,heights);
        // int res= stepDp(index,dp,heights);
        int res=stepDp(heights);
       System.out.print(res);


    }
    public static int steps(int index,int[] height){
        if(index==0){
            return 0;
        }
        int left=steps(index-1,height)+Math.abs(height[index]-height[index-1]);
        int right=Integer.MAX_VALUE;
        if(index>1) {
             right = steps(index - 2, height) + Math.abs(height[index] - height[index - 2]);
        }
        return Math.min(left,right);
    }
    //dp using memorization

    public static int stepDp(int index,int[] dp,int[] height){
        if(index==0){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int left=steps(index-1,height)+Math.abs(height[index]-height[index-1]);
        int right=Integer.MAX_VALUE;
        if(index>1) {
            right = steps(index - 2, height) + Math.abs(height[index] - height[index - 2]);
        }
        return Math.min(left,right);
    }
    //Tabulation to d=reduce the space complexity
    public static int stepDp(int[] height){
        int prev=0;
        int prev2=0;
       for(int i =1;i<=height.length-1;i++) {
           int left = prev + Math.abs(height[i] - height[i - 1]);
           int right = Integer.MAX_VALUE;
           if (i > 1) {
               right = prev2 + Math.abs(height[i] - height[i - 2]);
           }
           int min=Math.min(left,right);
           prev2=prev;
           prev=min;
       }
       return prev;


    }
}