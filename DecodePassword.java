package Ibm;

public class DecodePassword {
    public static void main(String[] args){
        String password=decodePassword("796115110113721110141108");
        System.out.print(password);

    }
    public static  String decodePassword(String s){
        String current="";
        StringBuilder result=new StringBuilder();

        for(int i=s.length()-1;i>0;i=i-2){

            current=""+s.charAt(i)+s.charAt(i-1);
            int n=Integer.parseInt(current);
            if(n==32){
                result.append(" ");
            }
            else if(isInRange(n)){
                char ch=(char)n;
                result.append(ch);

            }else{
                if(i-2<0){

                    break;
                }
              current=  current+s.charAt(i-2);
                int ans=Integer.parseInt(current);
                char c=(char)ans;

                result.append(c);
                i--;
            }

        }
        return result.toString();
    }
    public static boolean isInRange(int n){
        return n>=65 &&n<=122;
    }

}