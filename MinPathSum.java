package Ibm;

public class MinPathSum {
    public static void main(String[] args){
        int[][] arr = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int res=minSum(arr,0,0);
        System.out.print(res);

    }
    public  static int minSum(int[][] arr,int r,int c){
       if(r== arr.length-1 && c==arr[0].length-1){
           return arr[r][c];
       }
       if(r== arr.length-1){
           return arr[r][c]+minSum(arr,r,c+1);
       }
       if(c== arr[0].length-1){
           return arr[r][c]+minSum(arr,r+1,c);
       }
       int left=minSum(arr,r+1,c);
       int down=minSum(arr,r,c+1);
       return arr[r][c]+Math.min(left,down);
    }
}
