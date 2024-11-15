package flore;

public class Tomato extends Vegetable {

    public Tomato() {
        draw[VegetableState.FEUILLE.ordinal()] = "t";
        draw[VegetableState.FLEUR.ordinal()] = "T";
    }
}
