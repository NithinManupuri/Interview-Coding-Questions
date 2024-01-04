package Ibm;

public class MaxLenSubSequence {
    public static void main(String[] args){
    int[] arr={5,4,6,11,1,16,8};
    int result=maxLen(0,-1,arr);
    System.out.print(result);
    }
    public static int maxLen(int index,int prev,int[] arr){
        if(index== arr.length){
            return 0;
        }
        int len=0+maxLen(index+1,prev,arr);
        if(prev==-1|| (arr[index]>arr[prev])){
            int take=1+maxLen(index+1,index,arr);
            len=Math.max(len,take);
        }
        return len;
    }
}
