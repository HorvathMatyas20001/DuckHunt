package sk.stuba.fei.uim.oop.card.actionCards;

import sk.stuba.fei.uim.oop.card.duckAndWaterCards.*;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.List;

public class ShootCard extends ActionCard{
    public ShootCard() { super("ShootCard"); }

    public void playActionCard(Player player, List<Boolean> aimDeck,List<Pond> pondDeck,Player[] players) {

        player.shoot(aimDeck,pondDeck,players);
    }
}
