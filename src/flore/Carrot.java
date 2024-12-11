package flore;

import java.util.Map;

public class Carrot extends Vegetable implements IRacePure {

    public Carrot() {
        draw[VegetableState.FEUILLE.ordinal()] = "c";
        draw[VegetableState.FLEUR.ordinal()] = "C";
    }

    @Override
    public void reproduce(Map<String, Integer> cart) {
        cart.put("carrot", cart.get("carrot") + 3);
    }
}
