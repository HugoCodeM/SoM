package java102;

import java.util.ArrayList;

import java102.Library.LibraryItem.Book;
import java102.Library.LibraryItem.DVD;

public class Main {

    public static void main (String args[]) {
        Point point = new Point(4, 3);
        System.out.println("x: " + point.x + "y: " + point.y);

        Point xTranslation = point.translateX(3); 
        Point yTranslation = point.translateY(-7); 
        Point xyTranslation = point.translateX(-4).translateY(-3);

        System.out.println("point: " + point); 
        System.out.println("x transl: " + xTranslation);
        System.out.println("y transl: " + yTranslation);
        System.out.println("xy transl: " + xyTranslation); 

        Point a = new Point(1, 2);  
        Point b = new Point(4, 6);  
        
        System.out.println(Point.distance(a, b));

        ArrayList<String> arr = new ArrayList<>();
        arr.add("Hello");
        arr.add("World");
        System.out.println(arr);
        arr.set(0, "Goodbye");
        System.out.println(arr); 
        ArrayList<Boolean> conditions = new ArrayList<>();
        conditions.add(true);
        conditions.add(arr.get(0) == "Hello");
        conditions.add(conditions.get(0) || conditions.get(1));
        System.out.println(conditions);

        ArrayList<Integer> intArr = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
	    intArr.add(0);

        System.out.println(intArr.size());
        System.out.println(intArr.get(32));

        Grid<Integer> grid = new Grid<>(5, 0);
        grid.set(2, 2, 4);
        System.out.println(grid);

    }

    public interface Shape {
    double area();
    }
    public class Circle implements Shape {
        public final Point center;
        public final double radius;
    
        public Circle(Point center, double radius) {
            this.center = center;
            this.radius = radius;
        }
    
        @Override
        public double area() {
            return Math.PI * Math.pow(radius, 2);
        }
    
        @Override
        public String toString() {
            return "(center: " + center + "; radius: " + radius + ")";
        }
    }
    public class Square implements Shape {
        public final Point corner;
        public final double sideLength;
    
        public Square(Point corner, double sideLength) {
            this.corner = corner;
            this.sideLength = sideLength;
        }
    
        @Override
        public double area() {
            return Math.pow(sideLength, 2);
        }
    
        @Override
        public String toString() {
            return "(corner: " + corner + "; side length: " + sideLength + ")";
        }
    }
    static double sumArea(Shape[] shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.area();
        }
        return sum;
        
    }
    
    public static void main(String[] args) {
        // Create some library items (Books and DVDs)
        Library.LibraryItem.Book book1 = new Library().new Book("Java Programming", "1234", "John Doe", 300);
        Library.LibraryItem.DVD dvd1 = new Library().new DVD("Inception", "5678", 148);
        Library.LibraryItem.Book book2 = new Library().new Book("Python Programming", "2345", "Jane Smith", 250);
        
        // Initially checking out the items
        book1.checkOut();
        dvd1.checkOut();
        book2.checkOut();
        
        // Print the checked-out status of the items
        System.out.println(book1.title + " checked out: " + !book1.available());
        System.out.println(dvd1.title + " checked out: " + !dvd1.available());
        System.out.println(book2.title + " checked out: " + !book2.available());

        // Now, call the returnAll method to return all items
        Library.LibraryItem[] items = {book1, dvd1, book2};
        returnAll(items);
        
        // Print the checked-out status of the items after returning them
        System.out.println(book1.title + " checked out: " + !book1.available());
        System.out.println(dvd1.title + " checked out: " + !dvd1.available());
        System.out.println(book2.title + " checked out: " + !book2.available());
    }

    // Static method that takes an array of LibraryItem objects and returns them all
    public static void returnAll(Library.LibraryItem[] items) {
        for (Library.LibraryItem item : items) {
            item.returnItem();
        }
    }
    
    public static void main(String[] args) {
        // Create some library items (Books and DVDs)
        Library.LibraryItem.Book book1 = new Library().new Book("Java Programming", "1234", "John Doe", 300);
        Library.LibraryItem.DVD dvd1 = new Library().new DVD("Inception", "5678", 148);
        Library.LibraryItem.Book book2 = new Library().new Book("Python Programming", "2345", "Jane Smith", 250);

        // Initially checking out some items
        book1.checkOut();
        dvd1.checkOut();

        // Print availability before calling availableItems
        System.out.println("Items checked out:");
        System.out.println(book1.title + " available: " + book1.available());
        System.out.println(dvd1.title + " available: " + dvd1.available());
        System.out.println(book2.title + " available: " + book2.available());

     
        Library.LibraryItem[] items = {book1, dvd1, book2};


        ArrayList<Library.LibraryItem> availableItemsList = availableItems(items);

      
        System.out.println("\nAvailable items:");
        for (Library.LibraryItem item : availableItemsList) {
            System.out.println(item.toString());
        }
    }

   
    public static ArrayList<Library.LibraryItem> availableItems(Library.LibraryItem[] items) {
        ArrayList<Library.LibraryItem> availableItemsList = new ArrayList<>();
        for (Library.LibraryItem item : items) {
            if (item.available()) {
                availableItemsList.add(item);
            }
        }
        return availableItemsList;
    }
}
}
   