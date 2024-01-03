package Ibm;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args){
        ArrayList<Integer> list=rotate(new ArrayList<>(Arrays.asList(1,2,3,4,5)),1);
        System.out.print(list);


    }
    public  static ArrayList<Integer> rotate(ArrayList<Integer> arr,int k){
        ArrayList<Integer> list=new ArrayList<>();
        for(int i =0;i<arr.size();i++){
            int val=arr.get((i+k)%arr.size());
            list.add(val);
        }
        return list;
    }
}
