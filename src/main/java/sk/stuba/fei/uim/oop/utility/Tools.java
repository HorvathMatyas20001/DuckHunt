package sk.stuba.fei.uim.oop.utility;
import java.util.List;

public class Tools {
    public static void printSeparator(){
        System.out.println("----------------------------");
    }
    public static boolean validInputInRange(int min, int max,int input){

        if(input >= min && input <= max) return true;
        else{
            System.out.println("The number you enter is either to big or to small. Re enter a valid number");
            return false;
        }

    }
    public static boolean checkAimDeckStatus(int target,List<Boolean> aimDeck){
        if(aimDeck.get(target-1)){
            System.out.println("The target you are trying to aim at is already aimd at");
            return true;
        }else return false;

    }
    //public static List initializeList(){return ;} concept
}
