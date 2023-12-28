package Ibm;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FrequencyCharacter {
    public static void main(String[] args){
        String ans=frequency("a3b1c4a2");
        System.out.print(ans);

    }
    public static String frequency(String s){
        HashMap<Character,Integer>  map=new HashMap<>();
        for(int i=0;i<s.length()-1;i+=2){
            char ch=s.charAt(i);
            int count=Character.getNumericValue(s.charAt(i+1));
             map.put(ch,map.getOrDefault(ch,0)+count);
        }
        StringBuilder res=new StringBuilder();
        TreeMap<Character,Integer> sortMap= new TreeMap<>(map);
        for(Map.Entry<Character,Integer>  m:sortMap.entrySet()){
            res.append(m.getKey()).append(m.getValue());
        }
         return res.toString();
    }
 }
