package sk.stuba.fei.uim.oop.card.actionCards.movementCards;

import sk.stuba.fei.uim.oop.card.actionCards.ActionCard;
import sk.stuba.fei.uim.oop.card.duckAndWaterCards.Pond;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScatterCard extends ActionCard {
    public ScatterCard() {
        super("ScatterCard");
    }
    public boolean playActionCard(List<Boolean> aimDeck, List<Pond> pondDeck, List<Player> players, int activePlayer, List<ActionCard> actionCardDeck) {

        List<Pond> boardPondDeck = new ArrayList<Pond>();
        for(int i=0; i<6; ++i){
            boardPondDeck.add(pondDeck.get(i));
        }
        Collections.shuffle(boardPondDeck);
        for(int i=0; i<6; ++i){
            pondDeck.set(i,boardPondDeck.get(i));
        }

    return true;
    }
}
