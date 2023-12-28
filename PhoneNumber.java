package Ibm;


import java.util.HashMap;

public class PhoneNumber {
    public static void main(String[] args){
        String ph="Nine Three Nine double Zero Six Eight Four One Nine";
        String digits=number(ph);
        System.out.print(digits);


    }
    public static String number(String s) {
        String[] arr = s.split("\\s+");
        String res = "";
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Zero",0);
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);
        map.put("Six", 6);
        map.put("Seven", 7);
        map.put("Eight", 8);
        map.put("Nine", 9);
        int i = 0;
        while (i < arr.length) {
            if (arr[i].equals("double")) {
                res += map.get(arr[i + 1]) + map.get(arr[i + 1]);
                i++;
            } else if (arr[i].equals("triple")) {
                res += map.get(arr[i + 1]) + map.get(arr[i + 1]) + map.get(arr[i + 1]);
                i++;
            } else {
                res += map.get(arr[i]);
                i++;
            }

        }
        return res;

    }
}
