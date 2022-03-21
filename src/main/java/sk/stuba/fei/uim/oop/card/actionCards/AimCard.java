package sk.stuba.fei.uim.oop.card.actionCards;


import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.utility.Tools;

import java.util.List;

public class AimCard extends ActionCard{
    public AimCard() {
        super("Aimcard");
    }

    public void playActionCard(Player player,List<Boolean> aimDeck) {
        System.out.println("Enter the position you want to aim at:");
        player.aimAt(aimDeck);
    }
}
