package sk.stuba.fei.uim.oop.duckHunt;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.card.duckAndWaterCards.*;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;
import sk.stuba.fei.uim.oop.utility.Tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DuckHunt {
    private final Player[] players;
    private List<Pond> pondDeck;
    private List<Boolean> aimDeck;


    public DuckHunt(){
        System.out.println("You are playing Duck Hunt");
        int numberOfPlayers = KeyboardInput.readInt("Enter number of players");
        players = new Player[numberOfPlayers];
        Tools.printSeparator();
        for (int i =0; i < numberOfPlayers; ++i){
            players[i] = new Player(KeyboardInput.readString("Enter PLAYER " + (i + 1) + "'s name"),("PLAYER" + (i+1)));
            System.out.println(players[i].getPlayerName()+" you are " + players[i].getPlayerId());
            Tools.printSeparator();
        }
        initializePond(numberOfPlayers,players);
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

    }

    private void startGame(){
        Collections.shuffle(pondDeck);
    }


}
