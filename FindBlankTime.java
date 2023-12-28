package Ibm;

public class FindBlankTime {


    public static void main(String[] args) {

        minMaxTime("03:@5:08");
    }

    public static void minMaxTime(String inputTime) {
        char[] timeArray = inputTime.toCharArray();
        int blankPosition = -1;

        // Find the position of the blank (@)
        for (int i = 0; i < timeArray.length; i++) {
            if (timeArray[i] == '@') {
                blankPosition = i;
                break;
            }
        }
        int maxValue=-1;
        int minValue=-1;
        if(blankPosition==0){
            minValue=0;
            maxValue=2;
        }
       else if(blankPosition==1){
            minValue=0;
            maxValue=4;
        }else{
           if(blankPosition%3==0){
               minValue=0;
               maxValue=5;
           }else{
               minValue=0;
               maxValue=9;
            }
        }

        timeArray[blankPosition] = (char) (minValue + '0');
        String currentTime = new String(timeArray);
        System.out.println("MIN " + inputTime + " -> " + currentTime);
        timeArray[blankPosition] = (char) (maxValue + '0');
        String maxTime = new String(timeArray);
        System.out.println("Max " + inputTime + " -> " + maxTime);


    }
}


