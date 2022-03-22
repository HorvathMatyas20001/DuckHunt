package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.card.actionCards.ActionCard;
import sk.stuba.fei.uim.oop.card.duckAndWaterCards.DuckCard;
import sk.stuba.fei.uim.oop.card.duckAndWaterCards.Pond;
import sk.stuba.fei.uim.oop.duckHunt.DuckHunt;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;


import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String playerName;
    private final String playerId;
    private int lives;
    private boolean alive;
    private List<ActionCard> hand;

    public Player(String playerName,String playerId){
        this.playerName = playerName;
        this.playerId = playerId;
        this.lives = 5;
        this.alive = true;
        this.hand = new ArrayList<ActionCard>();
    }

    public void aim(List<Boolean> aimDeck){
        int aimTarget;
        do {
            aimTarget = ZKlavesnice.readInt("Enter what tile you want to aim at:");
        }while(!validInputInRange(1,6,aimTarget) || checkAimDeckStatus(aimTarget,aimDeck));
        aimDeck.set(aimTarget-1,true);
        printSeparator();
    }

    public void shoot(List<Boolean> aimDeck, List<Pond> pondDeck, Player[] players) {
        int shootTarget;
        do {
            shootTarget = ZKlavesnice.readInt("Enter what tile you want to shoot at:");
        } while (!validInputInRange(1, 6, shootTarget) || checkAimDeckStatusForShooting(shootTarget, aimDeck));
        aimDeck.set(shootTarget - 1, false);
        printSeparator();
        checkIfDuckAndKillIt(pondDeck,players,shootTarget);
    }

    public void aimAndShoot(List<Boolean> aimDeck,List<Pond> pondDeck,Player[] players){
        int shootTarget;
        do {
            shootTarget = ZKlavesnice.readInt("Enter what tile you want to aim and shoot at:");
        } while (!validInputInRange(1, 6, shootTarget));
        aimDeck.set(shootTarget - 1, false);
        printSeparator();
        checkIfDuckAndKillIt(pondDeck,players,shootTarget);
    }

    public void drawActionCard(List<ActionCard> actionDeck){
        hand.add(actionDeck.get(0));
        actionDeck.remove(0);
    }

    public boolean checkAimDeckStatus(int target,List<Boolean> aimDeck){
        if(aimDeck.get(target-1)){
            System.out.println("The target you are trying to aim at is already aimed at");
            return true;
        }else return false;

    }

    public void checkIfDuckAndKillIt(List<Pond> pondDeck, Player[] players,int shootTarget){
        if (pondDeck.get(shootTarget - 1).getType() == ("Duck")) {
            System.out.println("you shot down duck of " + ((DuckCard) (pondDeck.get(shootTarget - 1))).getPlayerId());
            for (int i = 0; i < players.length; ++i) {
                if (players[i].getPlayerId().equals(((DuckCard) (pondDeck.get(shootTarget - 1))).getPlayerId())) {
                    players[i].setLives(players[i].getLives() - 1);
                    System.out.println(players[i].getPlayerId() + " has lost a live and now has: " + players[i].getLives() + " lives");
                }
            }
            pondDeck.remove(shootTarget - 1);
            printSeparator();
        }
    }
    public boolean checkAimDeckStatusForShooting(int target,List<Boolean> aimDeck) {
        if (aimDeck.get(target - 1)) {
            return false;
        } else {
            System.out.println("The target you are trying to shoot at is not aimed at");
            return true;
        }
    }
    public void printSeparator(){
        System.out.println("----------------------------");
    }

    public boolean validInputInRange(int min, int max,int input){

        if(input >= min && input <= max) return true;
        else{
            System.out.println("The number you enter is either to big or to small. Re enter a valid number");
            return false;
        }
    }
    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerId() {
        return playerId;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
