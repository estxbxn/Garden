package flore;

import java.util.AbstractMap;
import java.util.Random;

public class Beetroot extends Vegetable implements IOGM {

    public Beetroot() {
        draw[VegetableState.LEAF.ordinal()] = 'b';
        draw[VegetableState.FLOWER.ordinal()] = 'B';
    }

    @Override
    public AbstractMap.SimpleEntry<Integer, Integer> duplicate(int x, int y) {
        Random random = new Random();
        int newX = random.nextInt(0, x);
        int newY = random.nextInt(0, y);
        return new AbstractMap.SimpleEntry<>(newX, newY);
    }
}
