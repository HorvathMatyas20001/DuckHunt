package sk.stuba.fei.uim.oop.card.actionCards;

import sk.stuba.fei.uim.oop.card.duckAndWaterCards.Pond;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.List;

public class AimCard extends ActionCard{
    public AimCard() {
        super("Aimcard");
    }
    @Override
    public boolean playActionCard( List<Boolean> aimDeck, List<Pond> pondDeck,List<Player> players,int activePlayer,List<ActionCard> actionCardDeck) {
        boolean checkIfThereIsFalse = false;
        for(int i=0; i<aimDeck.size(); ++i) {
            if (!aimDeck.get(i)) {
                checkIfThereIsFalse = true;
            }
        }
        boolean checkIfWholeHandAimCard = true;
        for(int i=0;i<players.get(activePlayer).getHand().size(); ++i){
            if(!players.get(activePlayer).getHand().get(i).type.equals("Aimcard")){
                checkIfWholeHandAimCard = false;
            }
        }
        if(checkIfThereIsFalse){
            players.get(activePlayer).aim(aimDeck);
            return true;
        }else if(checkIfWholeHandAimCard){
            players.get(activePlayer).discardActionCard(actionCardDeck);
            return true;
        }else{
            System.out.println("sorry you cant play this card because whole board is aimed at ");
            return false;
        }
    }
}
