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

    private List<ActionCard> hand;

    public Player(String playerName,String playerId){
        this.playerName = playerName;
        this.playerId = playerId;
        this.lives = 1;

        this.hand = new ArrayList<ActionCard>();
    }

    public void aim(List<Boolean> aimDeck){
        int aimTarget;
        do {
            aimTarget = ZKlavesnice.readInt("Select what tile you want to aim at:");
        }while(!validInputInRange(1,6,aimTarget) || checkAimDeckStatus(aimTarget,aimDeck));
        aimDeck.set(aimTarget-1,true);
        printSeparator();
    }

    public void shoot(List<Boolean> aimDeck, List<Pond> pondDeck,List<Player> players) {
        int shootTarget;
        do {
            shootTarget = ZKlavesnice.readInt("Select what tile you want to shoot at:");
        } while (!validInputInRange(1, 6, shootTarget) || checkAimDeckStatusForShooting(shootTarget, aimDeck));
        aimDeck.set(shootTarget - 1, false);
        printSeparator();
        checkIfDuckAndKillIt(pondDeck,players,shootTarget);
    }

    public void aimAndShoot(List<Boolean> aimDeck,List<Pond> pondDeck,List<Player> players){
        int shootTarget;
        do {
            shootTarget = ZKlavesnice.readInt("Select what tile you want to aim and shoot at:");
        } while (!validInputInRange(1, 6, shootTarget));
        aimDeck.set(shootTarget - 1, false);
        printSeparator();
        checkIfDuckAndKillIt(pondDeck,players,shootTarget);
    }

    public void drawActionCard(List<ActionCard> actionCardDeck){
        hand.add(actionCardDeck.get(0));
        actionCardDeck.remove(0);
    }
    public void discardActionCard(List<ActionCard> actionCardDeck){
        System.out.println("Unfortunately you cant play any of your cards");
        System.out.println("Please select what card do you want to discard");
        int selectedCard=selectActionCardToDiscard();
        actionCardDeck.add(hand.get(selectedCard));
        hand.remove(selectedCard);
        drawActionCard(actionCardDeck);
    }
    public int selectActionCardToDiscard(){
        int cardYouWantToPlay;
        do {
            cardYouWantToPlay = ZKlavesnice.readInt("Select what card you want to discard (1-3):");
        }while(!validInputInRange(1,3,cardYouWantToPlay));
        return cardYouWantToPlay-1;
    }

    private boolean checkAimDeckStatus(int target,List<Boolean> aimDeck){
        if(aimDeck.get(target-1)){
            System.out.println("The target you are trying to aim at is already aimed at");
            return true;
        }else return false;

    }

    private void checkIfDuckAndKillIt(List<Pond> pondDeck,List<Player> players,int shootTarget){
        if (pondDeck.get(shootTarget - 1).getType() == ("Duck")) {
            System.out.println("you shot down duck of " + ((DuckCard) (pondDeck.get(shootTarget - 1))).getPlayerId());
            for (int i = 0; i < players.size(); ++i) {
                if (players.get(i).getPlayerId().equals(((DuckCard) (pondDeck.get(shootTarget - 1))).getPlayerId())) {
                    players.get(i).setLives(players.get(i).getLives() - 1);
                    System.out.println(players.get(i).getPlayerId() + " has lost a live and now has: " + players.get(i).getLives() + " lives");
                }
            }
            pondDeck.remove(shootTarget - 1);
            printSeparator();
        }
    }
    private boolean checkAimDeckStatusForShooting(int target,List<Boolean> aimDeck) {
        if (aimDeck.get(target - 1)) {
            return false;
        } else {
            System.out.println("The target you are trying to shoot at is not aimed at");
            return true;
        }
    }
    private void printSeparator(){
        System.out.println("----------------------------");
    }

    private boolean validInputInRange(int min, int max,int input){

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

    public List<ActionCard> getHand() {
        return hand;
    }
}
