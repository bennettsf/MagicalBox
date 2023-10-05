import java.util.ArrayList;

class Box {
    private final double width;
    private final double height;
    private final double depth;
    private final ArrayList<String> boxContents = new ArrayList<>();

    public Box(double width, double height, double depth) {
        if (width <= 0 || height <= 0 || depth <= 0) {
            throw new IllegalArgumentException("The height, width, and/or depth must be greater than 0.");
        }
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public double volume() {
        return width * depth * height;
    }

    public void addItem(String item) {
        if (item == null || item.isBlank()){
            throw new IllegalArgumentException("item must not be null or blank/empty");
        }

        if (boxContents.size() < 10) {
            boxContents.add(item.toLowerCase());
        } else {
            System.out.println("The box is already full! Remove an item first.");
        }
    }

    public void removeItem(String item) {
        if (boxContents.contains(item.toLowerCase())) {
            boxContents.remove(item);
        } else {
            System.out.println("That item doesn't exist in the box!");
        }
    }

    public void printItems() {
        for (String boxContent : boxContents) {
            System.out.println(boxContent);
        }
    }

    public ArrayList<String> getBoxContents() {
        return boxContents;
    }
}

class BoxDemo {
    public static void main(String[] args) {
        Box a = new Box(7.3, 4.5, 20.7);
        a.addItem("wrench");
        a.addItem("apple");
        a.addItem("banana");
        a.addItem("headphones");
        a.addItem("hat");
        a.addItem("Water Bottle");
        a.addItem("scissors");
        a.addItem("duct tape");
        a.addItem("toothbrush");
        a.addItem("shoes");
        a.printItems();
        a.addItem("banana");
        a.removeItem("sunglasses");
        double volume = a.volume();
        System.out.printf("The volume of the magical box is: %.2f", volume);
    }
}