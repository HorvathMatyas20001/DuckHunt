package sk.stuba.fei.uim.oop.utility;
import sk.stuba.fei.uim.oop.card.duckAndWaterCards.DuckCard;
import sk.stuba.fei.uim.oop.card.duckAndWaterCards.Pond;
import sk.stuba.fei.uim.oop.player.Player;

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
            System.out.println("The target you are trying to aim at is already aimed at");
            return true;
        }else return false;

    }
    public static boolean checkAimDeckStatusForShooting(int target,List<Boolean> aimDeck) {
        if (aimDeck.get(target - 1)) {
            return false;
        } else {
            System.out.println("The target you are trying to shoot at is not aimed at");
            return true;
        }
    }

    public static void checkIfDuckAndKillIt(List<Pond> pondDeck, Player[] players,int shootTarget){
        if (pondDeck.get(shootTarget - 1).getType() == ("Duck")) {
            System.out.println("you shot down duck of " + ((DuckCard) (pondDeck.get(shootTarget - 1))).getPlayerId());
            for (int i = 0; i < players.length; ++i) {
                if (players[i].getPlayerId().equals(((DuckCard) (pondDeck.get(shootTarget - 1))).getPlayerId())) {
                    players[i].setLives(players[i].getLives() - 1);
                    System.out.println(players[i].getPlayerId() + " has lost a live and now has: " + players[i].getLives() + " lives");
                }
            }
            pondDeck.remove(shootTarget - 1);
            Tools.printSeparator();
        }
    }

    //public static List initializeList(){return ;} concept
}
