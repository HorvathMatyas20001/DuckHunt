package sk.stuba.fei.uim.oop.card.actionCards.movementCards;

import sk.stuba.fei.uim.oop.card.actionCards.ActionCard;
import sk.stuba.fei.uim.oop.card.duckAndWaterCards.Pond;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.List;

public class TurboDuckCard extends ActionCard{
    public TurboDuckCard() {
        super("TurboDuckCard");
    }
    public boolean playActionCard(List<Boolean> aimDeck, List<Pond> pondDeck, List<Player> players, int activePlayer, List<ActionCard> actionCardDeck) {
        boolean isItADuck = false;
        do{
            int select;
            select = ZKlavesnice.readInt("Select witch duck you want to put on top of the pond")-1;
            if(pondDeck.get(select).getType().equals("Duck")){
                Pond temp;
                temp = pondDeck.get(select);
                pondDeck.remove(select);
                pondDeck.add(0,temp);
                isItADuck = true;
            }else System.out.println("The card you selected is not a duck");

        }while( !isItADuck );


        return true;
    }
}
