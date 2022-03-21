package sk.stuba.fei.uim.oop.card.actionCards;

import sk.stuba.fei.uim.oop.card.duckAndWaterCards.Pond;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.List;

public abstract class ActionCard {
    protected String type;
    public ActionCard(String type) { this.type = type; }

    //public abstract void playActionCard(Player player,List<Boolean> aimDeck,List<Pond> pondDeck);


}
