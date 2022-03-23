package sk.stuba.fei.uim.oop.card.actionCards;

import sk.stuba.fei.uim.oop.card.duckAndWaterCards.*;
import sk.stuba.fei.uim.oop.duckHunt.DuckHunt;
import sk.stuba.fei.uim.oop.player.Player;


import java.util.List;

public class ShootCard extends ActionCard {
    public ShootCard() {
        super("ShootCard");
    }
    @Override
    public boolean playActionCard(Player player, List<Boolean> aimDeck, List<Pond> pondDeck, Player[] players,int activePlayer) {
        boolean checkWholeBoardFalse=false;
        for(int i=0; i<aimDeck.size(); ++i){
            if(aimDeck.get(i)){
                checkWholeBoardFalse =true;
            }
        }
        if(checkWholeBoardFalse) {
            player.shoot(aimDeck, pondDeck, players);
            return true;
        }else{
            System.out.println("sorry you cant play this card because non of the Tiles are aimed at");
            return false;
        }
    }
}
