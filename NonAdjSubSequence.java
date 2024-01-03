package Ibm;

import java.util.Arrays;

public class NonAdjSubSequence {

    public static void main(String[] args){
     int[] arr={0,1,4,9};
       int[] dp=new int[arr.length+1];
        Arrays.fill(dp,-1);
     // System.out.print(max(arr.length-1,arr));
        //System.out.print(maxDp(arr.length-1,arr,dp));
        System.out.print(maxDp(arr));

    }
    public static int  max(int index,int[] arr){
        if(index==0){
            return arr[index];
        }
        if(index<0){
            return 0;
        }
        int a=arr[index]+max(index-2,arr);
        int b=0+max(index-1,arr);
        return Math.max(a,b);

    }
    //memoriation
    public static int  maxDp(int index,int[] arr,int[] dp){
        if(index==0){
            return arr[index];
        }
        if(dp[index]!=-1) {
            return dp[index];

        }if(index<0){
                return 0;
            }
        int a=arr[index]+maxDp(index-2,arr,dp);
        int b=0+maxDp(index-1,arr,dp);
        return  dp[index]=Math.max(a,b);

    }
    public static int  maxDp(int[] arr) {
        int prev2 = 0;
        int prev = arr[0];

        for (int index = 1; index < arr.length; index++) {
          int take=arr[index];
            if (index > 1) {
                take+=+ prev2;
            }
            int nottake = 0 + prev;
            int curr = Math.max(take ,nottake);
            prev2=prev;
            prev=curr;

        }
        return prev;
    }

}
