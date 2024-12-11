package flore;

import java.util.Map;

public class Carrot extends Vegetable implements IRacePure {

    public Carrot() {
        draw[VegetableState.LEAF.ordinal()] = 'c';
        draw[VegetableState.FLOWER.ordinal()] = 'C';
    }

    @Override
    public void reproduce(Map<String, Integer> cart) {
        cart.put("carrot", cart.get("carrot") + 3);
    }
}
