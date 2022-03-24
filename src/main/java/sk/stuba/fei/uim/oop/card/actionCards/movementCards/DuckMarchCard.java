package sk.stuba.fei.uim.oop.card.actionCards.movementCards;

import sk.stuba.fei.uim.oop.card.actionCards.ActionCard;
import sk.stuba.fei.uim.oop.card.duckAndWaterCards.Pond;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.List;

public class DuckMarchCard extends ActionCard {
    public DuckMarchCard() {
        super("DuckMarchCard");
    }
    public boolean playActionCard(List<Boolean> aimDeck, List<Pond> pondDeck, List<Player> players, int activePlayer, List<ActionCard> actionCardDeck){
        Pond temp;
        temp=pondDeck.get(0);
        pondDeck.remove(0);
        pondDeck.add(temp);
        return true;
    }
}
