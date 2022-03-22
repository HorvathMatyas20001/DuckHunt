package sk.stuba.fei.uim.oop.card.actionCards;

import sk.stuba.fei.uim.oop.player.Player;

import java.util.List;

public class AimCard extends ActionCard{
    public AimCard() {
        super("Aimcard");
    }

    public void playActionCard(Player player,List<Boolean> aimDeck) {
        player.aim(aimDeck);
    }
}
