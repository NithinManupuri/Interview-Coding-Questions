package Ibm;

public class MaxSubArray {
    public static void main(String[] args){
        int[] arr={-3,9,1,3,-4,1,-7,-2,1};
        int[] result=maxArray(arr);
        int start=result[0];
        int end=result[1];
        int sum=result[2];
        printArray(arr,start,end);
        System.out.print(sum);
    }
    public static int[] maxArray(int[] arr){
        int max=Integer.MIN_VALUE;

        int sum=0;
        int start=-1;
        int ansstart=-1;
        int end=-1;
        for(int i=0;i<arr.length;i++){
            if(sum==0){
                start=i;
            }
            sum+=arr[i];
            if(sum>max){
                max=sum;
                ansstart=start;
                end=i;

            }
            if(sum<0){
                sum=0;
            }
        }
        return new int[]{ansstart,end,max};
    }
    public static void printArray(int[] arr, int start, int end) {
        System.out.print("[");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i]);
            if (i < end) {
                System.out.print(", ");
            }
        }
        System.out.print ("] : ");
    }
}
