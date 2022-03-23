package sk.stuba.fei.uim.oop.card.actionCards.movementCards;

import sk.stuba.fei.uim.oop.card.actionCards.ActionCard;
import sk.stuba.fei.uim.oop.card.duckAndWaterCards.Pond;
import sk.stuba.fei.uim.oop.player.Player;


import java.util.Collections;
import java.util.List;

public class DuckDanceCard extends ActionCard {
    public DuckDanceCard() {
        super("DuckDanceCard");
    }
    public boolean playActionCard(List<Boolean> aimDeck, List<Pond> pondDeck, List<Player> players, int activePlayer, List<ActionCard> actionCardDeck){
        Collections.shuffle(pondDeck);
        return true;
    }


}
