import java.util.Scanner;

public class Earth {

    public static void main(String[] args) {
        // Garden
        Garden garden = new Garden(5, 5);

        // Add seeds to cart
        garden.addToCart("beetroot", 4);
        garden.addToCart("carrot", 10);
        garden.addToCart("tomato", 10);
        garden.addToCart("garlic", 10);

        while (true) {
            // Run the garden
            run(garden);
        }
    }

    public static void run(Garden garden) {
        // Display options
        System.out.println();
        System.out.println();
        System.out.println("Choose an option:");
        System.out.println("1. Sow seeds");
        System.out.println("2. Harvest mature plants");
        System.out.println("3. Next season");
        System.out.println("4. Quit");

        Scanner scanner = new Scanner(System.in);
        int res;
        try {
            res = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
            return;
        }

        // User choice
        switch (res) {
            case 1 -> garden.sowSeed(scanner);
            case 2 -> garden.harvestMaturePlants(scanner);
            case 3 -> garden.nextSeason();
            default -> System.exit(1);
        }

        // Display the final garden
        garden.toString();
    }
}
