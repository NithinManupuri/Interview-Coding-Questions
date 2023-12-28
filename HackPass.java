package Ibm;

public class HackPass {
    public static void main(String[] args){
        allCombinatons("","1234");
    }
    public static void allCombinatons(String pass, String s) {
        if (s.isEmpty()) {
            System.out.print(pass);
            return;
        }


        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                char ch = (char) (s.charAt(0) + 96);
            } else {
                char ch = (char) (s.charAt(i) + s.charAt(i - 1));
                if (ch > 122) {
                    allCombinatons(pass + s.charAt(i), s.substring(2));
                    i++;

                }
                allCombinatons(pass + ch, s.substring(1));

            }
        }
    }
}
