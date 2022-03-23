package sk.stuba.fei.uim.oop.duckHunt;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.card.duckAndWaterCards.*;
import sk.stuba.fei.uim.oop.card.actionCards.*;
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
        }while(!validInputInRange(2,6,numberOfPlayers));

        players = new Player[numberOfPlayers];
        printSeparator();
        for (int i =0; i < numberOfPlayers; ++i){
            players[i] = new Player(ZKlavesnice.readString("Enter PLAYER " + (i + 1) + "'s name:"),("PLAYER" + (i+1)));
            System.out.println(players[i].getPlayerName()+" you are " + players[i].getPlayerId());
            printSeparator();
        }
        initializePond(numberOfPlayers,players);
        initializeActionCardDeck();
        startGame();
    }


    private void initializePond(int numberOfPlayers, Player[] players) {
        pondDeck = new ArrayList<Pond>();
        aimDeck = new ArrayList<Boolean>();
        for (int i = 0; i < numberOfPlayers; ++i) {
            for (int j = 0; j < players[i].getLives(); ++j) {
                pondDeck.add(new DuckCard(players[i].getPlayerId()));
            }
        }
        for (int i = 0; i < 5; ++i) {
            pondDeck.add(new WaterCard());
        }
        for (int i = 0; i < 6; ++i) {
            aimDeck.add(false);
        }
    }

    private void initializeActionCardDeck() {
        actionCardDeck = new ArrayList<ActionCard>();
        for (int i = 0; i < 10; ++i) {
            actionCardDeck.add(new AimCard());
        }
        for (int i = 0; i < 12; ++i) {
            actionCardDeck.add(new ShootCard());
        }
        for (int i = 0; i < 2; ++i) {
            actionCardDeck.add(new WildBillCard());
        }
    }
    private void printSeparator(){
        System.out.println("----------------------------");
    }

    private void printBoard(){
        for(int i=0; i<6; ++i){
            System.out.println(pondDeck.get(i).place() + ((aimDeck.get(i))?" - Aimed at":" - Not aimed at"));
        }
        printSeparator();
    }

    private void printHand(int activePlayer,Player[] players){
        System.out.println(players[activePlayer].getPlayerId() + ", you have:");
        for(int i=0; i<players[activePlayer].getHand().size(); ++i) {
            System.out.print(players[activePlayer].getHand().get(i).getType() + " ");
        }
        System.out.println();
        printSeparator();
    }

    public int selectActionCard(){
        int cardYouWantToPlay;
        do {
            cardYouWantToPlay = ZKlavesnice.readInt("Enter what card you want to play (1-3):");
        }while(!validInputInRange(1,3,cardYouWantToPlay));
        return cardYouWantToPlay-1;
    }

    private boolean validInputInRange(int min, int max,int input){

        if(input >= min && input <= max) return true;
        else{
            System.out.println("The number you enter is either to big or to small. Re enter a valid number");
            return false;
        }
    }
    private void checkIfDead(Player player,Player[] players,int activePlayer){
        if(player.getLives()==0)
        {
            //players.splice();
        }

    }

    private void startGame(){
        Collections.shuffle(pondDeck);
        Collections.shuffle(actionCardDeck);
        for(int i=0; i <players.length; ++i){
            for(int j=0; j<3; ++j) players[i].drawActionCard(actionCardDeck);
        }

        int activePlayer = 0;
        boolean didSomeoneWin = false;
        do {
            int selectedCard;
            boolean didPlayerPlayCard=false;

            do{
                printBoard();
                printHand(activePlayer,players);
                selectedCard=selectActionCard();
                didPlayerPlayCard=players[activePlayer].getHand().get(selectedCard).playActionCard(players[activePlayer],aimDeck,pondDeck,players,activePlayer);
            }while(!didPlayerPlayCard);

            players[activePlayer].drawActionCard(actionCardDeck);
            actionCardDeck.add(players[activePlayer].getHand().get(selectedCard));
            players[activePlayer].getHand().remove(selectedCard);
            activePlayer = (activePlayer + 1) % players.length;
        }while(!didSomeoneWin);


    }
}
