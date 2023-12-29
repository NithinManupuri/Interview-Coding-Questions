package Ibm;

public class EncryptionPass {
    public static void main(String[] args) {
        String keyWord = "luaxzn vsa filmrh bpm jxoh";
        String keyPhrase = "the greatest game ever played";
        String res = encrypt(keyWord, keyPhrase);
        if (res.equals("null")) {
            System.out.println("Invalid");
        } else {
            System.out.println(res);
        }
    }

    public static String encrypt(String keyWord, String keyPhrase) {
        StringBuilder sb = new StringBuilder();
        String[] word = keyWord.split("\\s+");
        String[] phrase = keyPhrase.split("\\s+");
        if (word.length != phrase.length) {
            return "null";
        }
        for (int i = 0; i < word.length; i++) {
            String w = word[i];
            String p = phrase[phrase.length-1-i];
            if (change(w, p, p.length()).equals("invalid")) {
                System.out.println("Invalid");
                return null;
            }
            sb.append(change(w, p, p.length())).append(" ");
        }
        return sb.toString().trim();
    }

    public static String change(String w, String p, int len) {
        if (len % 2 == 0) {
            return switchEven(w, p, len);
        } else {
            return switchOdd(w, p, len);
        }
    }

    public static String switchEven(String w, String p, int len) {
        StringBuilder sb = new StringBuilder();
        char[] ch = w.toCharArray();
        for (int i = 0; i < w.length(); i++) {
            if (Character.isUpperCase(ch[i])) {
                return "invalid";
            } else {
                char shifted = (char) (ch[i] - len);
                if (shifted > 'z'|| shifted<'a') {
                    shifted += 26;
                }
                sb.append(shifted);
            }
        }
        return sb.toString();
    }

    public static String switchOdd(String w, String p, int len) {
        StringBuilder sb = new StringBuilder();
        char[] ch = w.toCharArray();
        for (int i = 0; i < w.length(); i++) {
            if (Character.isUpperCase(ch[i])) {
                return "invalid";
            } else {
                char shifted = (char) (ch[i] + len);
                if (shifted < 'a' ||shifted>'z') {
                    shifted -= 26;
                }
                sb.append(shifted);
            }
        }
        return sb.toString();
    }
}
