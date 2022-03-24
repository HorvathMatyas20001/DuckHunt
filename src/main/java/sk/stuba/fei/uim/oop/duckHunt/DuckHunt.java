package sk.stuba.fei.uim.oop.duckHunt;


import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.card.duckAndWaterCards.*;
import sk.stuba.fei.uim.oop.card.actionCards.*;
import sk.stuba.fei.uim.oop.card.actionCards.movementCards.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DuckHunt {
    private final List<Player> players;
    private List<Pond> pondDeck;
    private List<ActionCard> actionCardDeck;
    private List<Boolean> aimDeck;


    public DuckHunt(){
        System.out.println("You are playing Duck Hunt");
        int numberOfPlayers;
        do {
            numberOfPlayers = ZKlavesnice.readInt("Enter number of players (2-6):");
        }while(!validInputInRange(2,6,numberOfPlayers));

        players = new ArrayList<Player>();

        printSeparator();
        for (int i =0; i < numberOfPlayers; ++i){
            players.add(new Player(ZKlavesnice.readString("Enter PLAYER " + (i + 1) + "'s name:"),("PLAYER" + (i+1))));
            System.out.println(players.get(i).getPlayerName()+" you are " + players.get(i).getPlayerId());
            printSeparator();
        }
        initializePond(numberOfPlayers,players);
        initializeActionCardDeck();
        startGame();
    }


    private void initializePond(int numberOfPlayers, List<Player> players) {
        pondDeck = new ArrayList<Pond>();
        aimDeck = new ArrayList<Boolean>();
        for (int i = 0; i < numberOfPlayers; ++i) {
            for (int j = 0; j < players.get(i).getLives(); ++j) {
                pondDeck.add(new DuckCard(players.get(i).getPlayerId()));
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
        for (int i = 0; i < 6; ++i) {
            actionCardDeck.add(new DuckMarchCard());
        }
        for (int i = 0; i < 1; ++i) {
            actionCardDeck.add(new TurboDuckCard());
        }
        for (int i = 0; i < 2; ++i) {
            actionCardDeck.add(new ScatterCard());
        }
        for (int i = 0; i < 1; ++i) {
            actionCardDeck.add(new DuckDanceCard());
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

    private void printHand(int activePlayer,List<Player> players){
        System.out.println(players.get(activePlayer).getPlayerId() + ", you have:");
        for(int i=0; i<players.get(activePlayer).getHand().size(); ++i) {
            System.out.print("["  + (i+1) + "] "+ players.get(activePlayer).getHand().get(i).getType() + " ");
        }
        System.out.println();
        printSeparator();
    }

    public int selectActionCard(){
        int cardYouWantToPlay;
        do {
            cardYouWantToPlay = ZKlavesnice.readInt("Select what card you want to play (1-3):");
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
    private void checkIfDead(List<Player> players){
        for(int i=0; i<players.size(); ++i){
            if(players.get(i).getLives()==0){
                System.out.println(players.get(i).getPlayerId() + " has died good luck next time " + players.get(i).getPlayerName());
                players.remove(i);
            }
        }
    }

    private void startGame(){
        Collections.shuffle(pondDeck);
        Collections.shuffle(actionCardDeck);
        for(int i=0; i <players.size(); ++i){
            for(int j=0; j<3; ++j) players.get(i).drawActionCard(actionCardDeck);
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
                didPlayerPlayCard=players.get(activePlayer).getHand().get(selectedCard).playActionCard(aimDeck,pondDeck,players,activePlayer,actionCardDeck);
            }while(!didPlayerPlayCard);

            checkIfDead(players);
            if (players.size()==1) {
                didSomeoneWin = true;
                break;
            }

            players.get(activePlayer).drawActionCard(actionCardDeck);
            actionCardDeck.add(players.get(activePlayer).getHand().get(selectedCard));
            players.get(activePlayer).getHand().remove(selectedCard);

            activePlayer = (activePlayer + 1) % players.size();
        }while(!didSomeoneWin);

        System.out.println(players.get(0).getPlayerId() + " has won the game. well done " + players.get(0).getPlayerName() );


    }
}
