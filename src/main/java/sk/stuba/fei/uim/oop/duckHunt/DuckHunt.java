package sk.stuba.fei.uim.oop.duckHunt;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.card.duckAndWaterCards.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class DuckHunt {
    private final Player[] players;




    public DuckHunt(){
        System.out.println("You are playing Duck Hunt");
        int numberOfPlayers = ZKlavesnice.readInt("Enter number of players: ");
        players = new Player[numberOfPlayers];
        for (int i =0; i < numberOfPlayers; i++){
            players[i] = new Player(ZKlavesnice.readString("Enter Player " + (i + 1) + " name:"));
        }

    }


}
