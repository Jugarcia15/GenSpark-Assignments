import java.util.ArrayList;

public class disariumNumbers {
    public static void main(String[] args){
        int count = 0;
        int num=1;
        //generate First 19 nums
        while(count < 19){
            if(isDisarium(num)){
                System.out.println(num);
                count++;
            }
            num++;
        }
    }
    //disarium sum of each digit raised to power of its position in number is equal to the number.

    //method checks if given number x is a disarium number.
    //Turn to string, iterate over each digit, summing powers.
    //if sum equals original number, then it is true, num is disarium. 
    private static boolean isDisarium(int x){
        String s = Integer.toString(x);
        int sum = 0;
        for (int i = 0 ; i < s.length(); i++){
            int pos = Character.getNumericValue(s.charAt(i));
            sum += Math.pow(pos, i+1);
        }
        return x == sum;
    }
}
