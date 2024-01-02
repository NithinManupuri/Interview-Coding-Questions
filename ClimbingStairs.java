package Ibm;

public class ClimbingStairs {
    public static void main(String[] args){
        int res=countWays(3);
        System.out.print(res);

    }
    public static int countWays(int index){
        if(index==0) {
            return 1;
        }
            if(index==1){
                return 1;
            }

        int left=countWays(index-1);
        int right=countWays(index-2);
        return left+right;
    }

}
