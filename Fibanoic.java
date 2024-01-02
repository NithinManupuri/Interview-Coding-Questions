package Ibm;

public class Fibanoic {
    public static void main(String[] args){
        int num=5;
        int[] dp= new int[num+1];
         for(int i=0;i<num+1;i++){//  we use here Arrays.fill(dp,-1)
            dp[i]=-1;
        }
        int res=fibanoic(num,dp);

      //int res=ftabulation(num);
        System.out.print(res);


    }
    //using dyanamic programmming
    //memorization ->it to tend to store the values of the sub problems ,it is a top to bottom approrach

    public static int fibanoic(int num,int[] dp){
        if(num<=1){
            return num;
        }
        if(dp[num]!=-1){
            return dp[num];
        }
        return dp[num]=fibanoic(num-1,dp)+fibanoic(num-2,dp);
    }
    //tabulation it is a bottom to up aparoach which is to reduce the recursion calls
    public static int ftabulation(int num){
        int prev=0;
        int pres=1;

        for(int i=2;i<num;i++){
            int fib=pres+prev;
            prev=pres;
            pres=fib;
        }
        return pres;
    }
}
