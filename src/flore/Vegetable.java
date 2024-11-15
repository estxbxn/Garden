package flore;

public abstract class Vegetable {

    private VegetableState state;
    protected final String[] draw;

    public Vegetable() {
        this.state = VegetableState.GRAINE;
        this.draw = new String[VegetableState.values().length];
        draw[VegetableState.GRAINE.ordinal()] = "_";
        draw[VegetableState.GERME.ordinal()] = ".";
        draw[VegetableState.TIGE.ordinal()] = "|";
        draw[VegetableState.MORT.ordinal()] = "#";
    }

    public void grow() {
        if (state == VegetableState.MORT) return;

        this.state = VegetableState.values()[this.state.ordinal() + 1];
    }

    public VegetableState getState() {
        return state;
    }

    public String[] getDraw() {
        return draw;
    }
}
