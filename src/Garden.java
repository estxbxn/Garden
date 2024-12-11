import flore.*;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Garden {

    private final int width;
    private final int length;
    private final Location[][] locations;
    private final Map<String, Integer> cart;

    public Garden(int width, int length) {
        this.width = width;
        this.length = length;
        this.locations = new Location[width][length];
        this.cart = new HashMap<>();
    }

    public void sowSeed(Scanner scanner) {
        System.out.println("Give the X coordinate of the seed");
        int x;
        try {
            x = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
            return;
        }

        System.out.println("Give the Y coordinate of the seed");
        int y;
        try {
            y = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
            return;
        }

        System.out.println("Which seed do you want to sow ?");
        String seedName = scanner.next();
        Vegetable seed;
        switch (seedName) {
            case "tomato" -> seed = new Tomato();
            case "carrot" -> seed = new Carrot();
            case "garlic" -> seed = new Garlic();
            case "beetroot" -> seed = new Beetroot();
            default -> {
                System.out.println("Please enter a valid seed name.");
                return;
            }
        }

        // Remove from cart the seed
        if (cart.get(seedName) == 0) {
            System.out.println();
            System.out.println("You have 0 seed for " + seedName);
            return;
        }

        // Check coordinates
        if (!isValidCoordinate(x, y)) return;
        locations[x][y] = new Location(seed);

        // Update the cart seed quantity
        cart.put(seedName, cart.get(seedName) - 1);
    }

    public void harvestMaturePlants(Scanner scanner) {
        System.out.println("Give the X coordinate of the vegetable");
        int x;
        try {
            x = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
            return;
        }

        System.out.println("Give the Y coordinate of the vegetable");
        int y;
        try {
            y = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
            return;
        }

        if (x < 0 || x >= width || y < 0 || y >= length) {
            System.out.println("Coordinates are out of bounds.");
            return;
        }

        Location location = locations[x][y];
        if (location == null) {
            System.out.println("There is no vegetable to harvest here.");
            return;
        }

        Vegetable currentVegetable = location.getVegetable();

        if (currentVegetable.getState() != VegetableState.FLOWER) {
            System.out.println("This seed can't be harvest for now.");
            return;
        }

        if (currentVegetable instanceof IRacePure vegetable) {
            vegetable.reproduce(cart);
        } else if (currentVegetable instanceof IOGM vegetable) {

            if (!hasFreeSpace()) {
                System.out.println("There is no free space available for this OGM seed.");
                locations[x][y] = null;
                return;
            }

            AbstractMap.SimpleEntry<Integer, Integer> entry;
            int randomX, randomY;

            do {
                entry = vegetable.duplicate(width, length);
                randomX = entry.getKey();
                randomY = entry.getValue();
            } while (!isValidCoordinate(randomX, randomY));

            switch (vegetable) {
                case Tomato tomato -> location.setVegetable(new Tomato());
                case Carrot carrot -> location.setVegetable(new Carrot());
                case Garlic garlic -> location.setVegetable(new Garlic());
                case Beetroot beetroot -> location.setVegetable(new Beetroot());
                default -> {
                }
            }

            locations[x][y] = null;
            locations[randomX][randomY] = location;
        }

        locations[x][y] = null;
    }

    public void nextSeason() {
        for (Location[] location : locations) {
            for (Location value : location) {
                if (value == null) continue;

                value.getVegetable().grow();
            }
        }
    }

    public void addToCart(String type, int quantity) {
        if (cart.containsKey(type)) {
            cart.put(type, cart.get(type) + quantity);
            return;
        }

        cart.put(type, quantity);
    }

    private boolean hasFreeSpace() {
        for (Location[] row : locations) {
            for (Location loc : row) {
                if (loc == null) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidCoordinate(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= length) {
            System.out.println("Coordinates are out of bounds.");
            return false;
        }
        if (locations[x][y] != null) {
            System.out.println("A seed is already sow at these coordinates.");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder gardenRepresentation = new StringBuilder();

        gardenRepresentation.append("There is our garden:\n");
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < width; y++) {
                Location plantLocation = locations[x][y];
                if (plantLocation == null) {
                    gardenRepresentation.append("o");
                } else {
                    gardenRepresentation.append(plantLocation);
                }
            }
            gardenRepresentation.append("\n");
        }

        gardenRepresentation.append("Cart contents:\n");
        for (String type : cart.keySet()) {
            gardenRepresentation.append(type)
                    .append(" : ")
                    .append(cart.get(type))
                    .append(" seed(s)\n");
        }

        return gardenRepresentation.toString();
    }
}
