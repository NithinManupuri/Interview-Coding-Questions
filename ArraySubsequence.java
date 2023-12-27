package week3;

import java.util.ArrayList;
import java.util.List;

public class ArraySubsequence {
  public static void main(String[] args){
      int[] arr={1,2,2,3};
     // List<List<Integer>> list=subSequence(arr);
      List<List<Integer>> list=dupSequence(arr);
      System.out.print(list);

  }

    public static List<List<Integer>> subSequence(int[] arr) {
      List<List<Integer>>  outer=new ArrayList<>();
      outer.add(new ArrayList<>());


      for(int num:arr){
          int n=outer.size();
          for(int j=0;j<n;j++){
              List<Integer> internal=new ArrayList<>(outer.get(j));
              internal.add(num);
              outer.add(internal);
          }
      }
      return outer;
  }

  public static List<List<Integer>> dupSequence(int[] arr){
    List<List<Integer>> outer=new ArrayList<>();
    outer.add(new ArrayList<>());
    int start=0;
    int end=0;

      for(int i=0;i<arr.length;i++){
          start=0;
          if(i>0&&arr[i]==arr[i-1]){
              start=end+1;
          }
          end=outer.size()-1;
          int n=outer.size();
          for(int j=start;j<n;j++){
              List<Integer> internal=new ArrayList<>(outer.get(j));
              internal.add(arr[i]);
              outer.add(internal);
          }
    }
 return  outer;
  }
}
