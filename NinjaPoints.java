package Ibm;
/*problem statement
Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?

        You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. Your task is to calculate the maximum number of merit points that Ninja can earn.

        For Example
        If the given ‘POINTS’ array is [[1,2,5], [3 ,1 ,1] ,[3,3,3] ],the answer will be 11 as 5 + 3 + 3.*/

import java.util.Arrays;

import static java.util.Arrays.fill;

public class NinjaPoints {
    public static void main(String[] args){
        int[][] arr={{1,2,5},{3,1,1},{3,3,3}};
        int[][] dp = new int[4][4];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result=maxPoints(2,3,arr,dp);
        System.out.print(result);

    }
    public static  int maxPoints(int day,int except,int[][] arr,int[][] dp){
        if(day==0){
            int max=0;
            for( int task=0;task<3;task++){
                if(task!=except){
                    int point=arr[day][task];
                    max=Math.max(point,max);
                }
            }
            return  dp[day][except]=max;
        }
        if(dp[day][except]!=-1){

        }
        int max=0;
        for(int task=0;task<3;task++){

            if(task!=except){
                int  points=arr[day][task]+maxPoints(day-1,task,arr,dp);
                max=Math.max(points,max);

            }

        }
        return dp[day][except]=max;


    }
}
