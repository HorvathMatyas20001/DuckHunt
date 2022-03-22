package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.card.actionCards.ActionCard;
import sk.stuba.fei.uim.oop.card.duckAndWaterCards.DuckCard;
import sk.stuba.fei.uim.oop.card.duckAndWaterCards.Pond;
import sk.stuba.fei.uim.oop.utility.Tools;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;


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
        //this.hand = new ArrayList<>();
    }

    public void aim(List<Boolean> aimDeck){
        int aimTarget;
        do {
            aimTarget = ZKlavesnice.readInt("Enter what tile you want to aim at:");
        }while(!Tools.validInputInRange(1,6,aimTarget) || Tools.checkAimDeckStatus(aimTarget,aimDeck));
        aimDeck.set(aimTarget-1,true);
        Tools.printSeparator();
    }

    public void shoot(List<Boolean> aimDeck, List<Pond> pondDeck, Player[] players) {
        int shootTarget;
        do {
            shootTarget = ZKlavesnice.readInt("Enter what tile you want to shoot at:");
        } while (!Tools.validInputInRange(1, 6, shootTarget) || Tools.checkAimDeckStatusForShooting(shootTarget, aimDeck));
        aimDeck.set(shootTarget - 1, false);
        Tools.printSeparator();
        Tools.checkIfDuckAndKillIt(pondDeck,players,shootTarget);
    }

    public void aimAndShoot(List<Boolean> aimDeck,List<Pond> pondDeck,Player[] players){
        int shootTarget;
        do {
            shootTarget = ZKlavesnice.readInt("Enter what tile you want to aim and shoot at:");
        } while (!Tools.validInputInRange(1, 6, shootTarget));
        aimDeck.set(shootTarget - 1, false);
        Tools.printSeparator();
        Tools.checkIfDuckAndKillIt(pondDeck,players,shootTarget);
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
