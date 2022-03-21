package sk.stuba.fei.uim.oop.utility;

public class GetValidInput {
    public static boolean validInputInRange(int min, int max,int input){
        boolean valid;
        if(input >= min && input <= max){
            valid = true;
        }
        else{
            valid =false;
            System.out.println("The number you enter is either to big or to small. Re enter a valid number");
        }

        return valid;
    }
}
