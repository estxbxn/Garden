package flore;

import java.util.Map;

public class Garlic extends Vegetable implements IRacePure {

    public Garlic() {
        draw[VegetableState.LEAF.ordinal()] = 'g';
        draw[VegetableState.FLOWER.ordinal()] = 'G';
    }

    @Override
    public void reproduce(Map<String, Integer> cart) {
        cart.put("garlic", cart.get("garlic") + 3);
    }
}
