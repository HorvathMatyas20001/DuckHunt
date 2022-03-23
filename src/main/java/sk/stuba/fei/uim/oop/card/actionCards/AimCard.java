package sk.stuba.fei.uim.oop.card.actionCards;

import sk.stuba.fei.uim.oop.card.duckAndWaterCards.Pond;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.List;

public class AimCard extends ActionCard{
    public AimCard() {
        super("Aimcard");
    }
    @Override
    public boolean playActionCard(Player player, List<Boolean> aimDeck, List<Pond> pondDeck, Player[] players,int activePlayer) {
        boolean checkWholeBoardTrue=false;
        for(int i=0; i<aimDeck.size(); ++i) {
            if (!aimDeck.get(i)) {
                checkWholeBoardTrue = true;
            }
        }
        if(checkWholeBoardTrue){
            player.aim(aimDeck);
            return true;
        }else{
            System.out.println("sorry you cant play this card because whole board is aimed at ");
            return false;
        }
    }
}
