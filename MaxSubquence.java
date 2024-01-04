package Ibm;
import java.util.ArrayList;
import  java.util.List;
public class MaxSubquence {
    public static  void main(String[] args){
        int max=Integer.MIN_VALUE;
        int sum=0;
        int[] arr={1,2,3,4};
        List<List<Integer>> list=subSequences(arr);
        for(List<Integer> l:list){
            int length=l.size();
            sum=0;
            if(length==3){
                for(int num:l){
                    sum+=num;
                }
            }
            if(sum>max){
                max=sum;
            }

        }
        System.out.print(max);

    }
    public static List<List<Integer>> subSequences(int[] arr){
        List<List<Integer>> list=new ArrayList<>();
        list.add(new ArrayList<>());
        for(int num:arr){
            int n=list.size();
            for(int i=0;i<n;i++){
                ArrayList<Integer> internal=new ArrayList<>(list.get(i));
                internal.add(num);
                list.add(internal);
            }

        }

        return list;
    }
}
