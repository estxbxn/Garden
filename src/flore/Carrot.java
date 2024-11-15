package flore;

public class Beet extends Vegetable {

    public Beet() {
        super(VegetableState.GRAINE);
        getDraw().put(VegetableState.FEUILLE, "a");
        getDraw().put(VegetableState.FLEUR, "A");
    }
}
