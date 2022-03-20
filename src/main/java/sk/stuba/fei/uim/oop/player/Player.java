package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.card.actionCards.ActionCard;
import sk.stuba.fei.uim.oop.card.duckAndWaterCards.DuckCard;


import java.util.ArrayList;

public class Player {

    private final String playerName;
    private final String playerId;
    private int lives;
    private boolean alive;


    //private ActionCard hand;


    public Player(String playerName,String playerId){
        this.playerName = playerName;
        this.playerId = playerId;
        this.lives = 5;
        this.alive = true;

        //this.hand = new ArrayList<>();
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
}
