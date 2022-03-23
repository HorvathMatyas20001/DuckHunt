package sk.stuba.fei.uim.oop.card.actionCards;

import sk.stuba.fei.uim.oop.card.duckAndWaterCards.Pond;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.List;

public class WildBillCard extends ActionCard{
    public WildBillCard() {
        super("WildBillCard");
    }
    @Override
    public boolean playActionCard( List<Boolean> aimDeck, List<Pond> pondDeck,List<Player> players,int activePlayer,List<ActionCard> actionCardDeck) {
        players.get(activePlayer).aimAndShoot(aimDeck,pondDeck,players);
        return true;
    }
}
