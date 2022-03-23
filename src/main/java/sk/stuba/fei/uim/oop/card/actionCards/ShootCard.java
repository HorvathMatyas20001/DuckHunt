package sk.stuba.fei.uim.oop.card.actionCards;

import sk.stuba.fei.uim.oop.card.duckAndWaterCards.*;
import sk.stuba.fei.uim.oop.duckHunt.DuckHunt;
import sk.stuba.fei.uim.oop.player.Player;


import java.util.List;

public class ShootCard extends ActionCard {
    public ShootCard() {
        super("ShootCard");
    }
    @Override
    public boolean playActionCard( List<Boolean> aimDeck, List<Pond> pondDeck,List<Player> players,int activePlayer,List<ActionCard> actionCardDeck) {
        boolean checkIfThereIsTrue=false;
        for(int i=0; i<aimDeck.size(); ++i){
            if(aimDeck.get(i)){
                checkIfThereIsTrue =true;
            }
        }
        boolean checkIfWholeHandShootCard = true;
        for(int i=0;i<players.get(activePlayer).getHand().size(); ++i) {
            if (!players.get(activePlayer).getHand().get(i).type.equals("ShootCard")) {
                checkIfWholeHandShootCard = false;
            }
        }
        if(checkIfThereIsTrue) {
            players.get(activePlayer).shoot(aimDeck, pondDeck, players);
            return true;
        }else if(checkIfWholeHandShootCard){
            players.get(activePlayer).discardActionCard(actionCardDeck);
            return true;
        }else{
            System.out.println("sorry you cant play this card because non of the Tiles are aimed at");
            return false;
        }
    }
}
