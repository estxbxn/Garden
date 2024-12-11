package flore;

public abstract class Vegetable {

    private VegetableState state;
    protected final char[] draw;

    public Vegetable() {
        this.state = VegetableState.SEED;
        this.draw = new char[VegetableState.values().length];
        draw[VegetableState.SEED.ordinal()] = '_';
        draw[VegetableState.SPROUT.ordinal()] = '.';
        draw[VegetableState.STEM.ordinal()] = '|';
        draw[VegetableState.DEAD.ordinal()] = '#';
    }

    public void grow() {
        if (state == VegetableState.DEAD) return;
        this.state = VegetableState.values()[this.state.ordinal() + 1];
    }

    public boolean isHarvestable() {
        return state == VegetableState.FLOWER;
    }

    @Override
    public String toString() {
        return String.valueOf(draw[state.ordinal()]);
    }
}
