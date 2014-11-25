class Plant {
    private String name;

    public Plant(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Plant() {
        this("fern");
    }
}

public class Tree extends Plant {
    
    public void growFruit() {}

    public void dropLeaves() {}
}