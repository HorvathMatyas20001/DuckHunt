package sk.stuba.fei.uim.oop.card.actionCards;

import sk.stuba.fei.uim.oop.card.duckAndWaterCards.Pond;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.List;

public class WildBillCard extends ActionCard{
    public WildBillCard(String type) { super("WildBillCard"); }

    public void playActionCard(Player player, List<Boolean> aimDeck, List<Pond> pondDeck, Player[] players) {
        player.aimAndShoot(aimDeck,pondDeck,players);

    }
}
