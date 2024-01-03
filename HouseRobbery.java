package Ibm;

public class HouseRobbery {
    public static void main(String[] args){
        int[] arr={1,2,3,1};
        int res=maxAmount(arr);
        System.out.print(res);

    }
    public static int maxAmount(int[] arr){
        int[] arr1=new int[arr.length-1];
        int[] arr2=new int[arr.length-1];
        for(int i=0;i< arr.length;i++) {
            if (i != 0) {
                arr1[i - 1] = arr[i];
            }

            if (i != arr.length - 1) {
                arr2[i] = arr[i];
            }
        }
        return Math.max(max(arr1),max(arr2));
    }

        public static  int max(int[] arr){

        int prev2=0;
        int prev=arr[0];
        for(int i=1;i< arr.length;i++){
            int take=arr[0];
            if(i>1){
                take+=prev2;
            }
            int untake=0+prev;
            int curr=Math.max(take,untake);
            prev2=prev;
            prev=curr;

        }

        return prev;


        }
    }
