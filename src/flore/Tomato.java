package flore;

public class Tomato extends Vegetable {

    public Tomato() {
        draw[VegetableState.LEAF.ordinal()] = 't';
        draw[VegetableState.FLOWER.ordinal()] = 'T';
    }
}
