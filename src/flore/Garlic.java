package flore;

import java.util.Map;

public class Garlic extends Vegetable implements IRacePure {

    public Garlic() {
        draw[VegetableState.FEUILLE.ordinal()] = "g";
        draw[VegetableState.FLEUR.ordinal()] = "G";
    }

    @Override
    public void reproduce(Map<String, Integer> cart) {
        cart.put("ail", cart.get("ail") + 3);
    }
}
