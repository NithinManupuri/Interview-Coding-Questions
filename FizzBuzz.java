package Ibm;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        print(n);

    }
    public static void print(int n){
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5==0){
               System.out.println("FizzBuzz");
            }
            if(i%3==0 && i%5!=0){
                System.out.println("Fizz");
            }
            if(i%3!=0 && i%5==0){
                System.out.println("Fizz");
            }
            if(i%3!=0 && i%5!=0){
                System.out.println(i);
            }

        }
    }

}
