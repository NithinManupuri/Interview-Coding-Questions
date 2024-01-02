package Ibm;
import java.util.ArrayList;
import java.util.List;
public class RecentIds {
    public static void main(String[] args){
        String[] str={"item1", "item2","item3", "item1", "item3"};
        List<String> l=recentIds(str);
        System.out.print(l);


    }
    public static List<String> recentIds(String[] str){
        List<String> list=new ArrayList<>();
        for(int i=str.length-1;i>=0;i--){
            if(!list.contains(str[i])){
                list.add(str[i]);
            }
        }
        return list;
    }
}
