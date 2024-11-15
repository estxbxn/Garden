package flore;

public class Beet extends Vegetable {

    public Beet() {
        draw[VegetableState.FEUILLE.ordinal()] = "b";
        draw[VegetableState.FLEUR.ordinal()] = "B";
    }
}
