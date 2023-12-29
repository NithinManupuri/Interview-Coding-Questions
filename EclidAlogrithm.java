package Ibm;

public class EclidAlogrithm {
    public static void main(String[] args){
        int a =8;
        int b=12;
        int Gcd=gcd(a,b);
        int Lcm=lcm(a,b);
        System.out.println("Gcd is:"+Gcd);
        System.out.print("Lcm is:"+Lcm);

    }
    public static int gcd(int a ,int b){
        if(a==0){
            return b;
        }
       return gcd(b%a,a);
    }
    public static int lcm(int a,int b){
        return a*b/gcd(a,b);
    }
}
