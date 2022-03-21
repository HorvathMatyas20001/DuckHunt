package sk.stuba.fei.uim.oop.duckHunt;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.card.duckAndWaterCards.*;
import sk.stuba.fei.uim.oop.card.actionCards.*;
import sk.stuba.fei.uim.oop.utility.Tools;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DuckHunt {
    private final Player[] players;
    private List<Pond> pondDeck;
    private List<ActionCard> actionCardDeck;
    private List<Boolean> aimDeck;


    public DuckHunt(){
        System.out.println("You are playing Duck Hunt");
        int numberOfPlayers;
        do {
            numberOfPlayers = ZKlavesnice.readInt("Enter number of players (2-6):");
        }while(!Tools.validInputInRange(2,6,numberOfPlayers));

        players = new Player[numberOfPlayers];
        Tools.printSeparator();
        for (int i =0; i < numberOfPlayers; ++i){
            players[i] = new Player(ZKlavesnice.readString("Enter PLAYER " + (i + 1) + "'s name:"),("PLAYER" + (i+1)));
            System.out.println(players[i].getPlayerName()+" you are " + players[i].getPlayerId());
            Tools.printSeparator();
        }
        initializePond(numberOfPlayers,players);
        initializeActionCardDeck();
        startGame();
    }



    private void initializePond(int numberOfPlayers,Player[] players){
        pondDeck = new ArrayList<Pond>();
        aimDeck = new ArrayList<Boolean>();
        for (int i=0; i<numberOfPlayers; ++i) {
            for(int j=0; j<players[i].getLives(); ++j){
                pondDeck.add(new DuckCard(players[i].getPlayerId()));
            }
        }
        for(int i=0; i<5; ++i){
            pondDeck.add(new WaterCard());
        }
        for(int i=0; i<6; ++i){
            aimDeck.add(false);
        }
    }

    private void initializeActionCardDeck(){

    }

    private void printBoard(){
        for(int i=0; i<6; ++i){
            System.out.println(pondDeck.get(i).place() + ((aimDeck.get(i))?" - Aimed at":" - Not aimed at"));
        }
        Tools.printSeparator();
    }

    private void startGame(){
        Collections.shuffle(pondDeck);
        printBoard();
        players[1].aimAt(aimDeck);
        printBoard();
        players[1].aimAt(aimDeck);
        printBoard();
    }

}
