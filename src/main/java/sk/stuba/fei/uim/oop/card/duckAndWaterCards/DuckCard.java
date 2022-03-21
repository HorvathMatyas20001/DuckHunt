package sk.stuba.fei.uim.oop.card.duckAndWaterCards;


public class DuckCard extends Pond {
    private final String playerId;

    @Override
    public String place() {
        return ("Duck of " + playerId);
    }

    public DuckCard(String playerId) {
        super("Duck");
        this.playerId = playerId;
    }

}
