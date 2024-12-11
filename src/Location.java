import flore.Vegetable;

public class Location {

    private Vegetable vegetable;

    public Location(Vegetable vegetable) {
        this.vegetable = vegetable;
    }

    public Vegetable getVegetable() {
        return vegetable;
    }

    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
    }

    @Override
    public String toString() {
        return vegetable.toString();
    }
}
