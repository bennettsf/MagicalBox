import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

    /*
    * I added a method in the box class (getBoxContents) that returns the ArrayList allowing for better testing
    */

    //testing Box class constructor
    @org.junit.jupiter.api.Test
    public void boxConstructor(){

        //test constructor with negative double args
        assertThrows(IllegalArgumentException.class,
                () -> new Box(5.9, 5.4, -10.0));
        //3 negatives
        assertThrows(IllegalArgumentException.class,
                () -> new Box(-5, -5, -65.3));
        //2 negatives
        assertThrows(IllegalArgumentException.class,
                () -> new Box(-31.3, 5.6, -12.2));
        //zeros
        assertThrows(IllegalArgumentException.class,
                () -> new Box(0, 0, 0));

    }

    //testing volume method
    @org.junit.jupiter.api.Test
    public void volume() {
        Box test = new Box(5, 5, 10);
        Box test2 = new Box(5, 5, 1.5);

        //test the computation of the box dimensions
        assertEquals(test.volume(), 250);
        assertEquals(test2.volume(), 37.5);

    }

    //testing addItem method
    @org.junit.jupiter.api.Test
    public void addItem() {
        Box test = new Box(5, 5, 10);
        test.addItem("baseball");
        test.addItem("basketball");
        test.addItem("football");
        test.addItem("baseball");
        test.addItem("basketball");
        test.addItem("football");
        test.addItem("baseball");
        test.addItem("basketball");
        test.addItem("football");
        test.addItem("football");

        //test the current size of the ArrayList
        assertEquals(10, test.getBoxContents().size());

        //test a blank string entry
        assertThrows(IllegalArgumentException.class,
                () -> test.addItem(""));

        //test a null string entry
        assertThrows(IllegalArgumentException.class,
                () -> test.addItem(null));

        //test the first item added to the box (baseball)
        assertEquals("baseball", test.getBoxContents().get(0));



    }

    //testing removeItem method
    @org.junit.jupiter.api.Test
    public void removeItem() {

        Box test = new Box(5, 5, 10);
        test.addItem("baseball");
        test.addItem("basketball");
        test.addItem("football");

        //test initial size of ArrayList after items are added
        assertEquals(3, test.getBoxContents().size());

        //remove basketball from the box
        test.removeItem("basketball");

        //test the size after one item gets removed
        assertEquals(2, test.getBoxContents().size());

        //test the index of football after basketball gets deleted
        assertEquals("football", test.getBoxContents().get(1));

        //check boxContents to see if basketball is still there
        assertEquals(false, test.getBoxContents().contains("basketball"));


    }

}