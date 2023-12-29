package Ibm;

public class KarpRabin {
    private final int PRIME=101;
    private double calculateHash(String str){
        double hash=0;
        for(int i=0;i<str.length();i++){
            hash=hash+ str.charAt(i)*Math.pow(PRIME,i);

        }
        return hash;
    }

    private double updatedHash(double prevHash, char oldChar, char newChar, int length) {
        double newHash = (prevHash - oldChar) / PRIME;
        newHash = newHash + newChar * Math.pow(PRIME, length - 1);
        return newHash;
    }
    public void  searchString(String string,String  pattern){
        int length=pattern.length();
        double stringHash=calculateHash(string.substring(0,length));
        double patternHash=calculateHash(pattern);
        for(int i=0;i<=string.length()-length;i++){
            if(patternHash==stringHash) {
                if (string.substring(i, i+length).equals(pattern)) {
                    System.out.print("found at index "+i);
                }
            }
              if(i<string.length()-length){
                stringHash=updatedHash(stringHash,string.charAt(i),string.charAt(i+length),length);
            }


        }
    }
}
class Main{
    public static void main(String[] args){
        KarpRabin kp=new KarpRabin();
        kp.searchString("SaiNithin","Nithin");
    }
}
