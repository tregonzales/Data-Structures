//Tre Gonzales fgonzales19@cmc.edu


import java.util.ListIterator;

public class UseDLL {

    public static void main(String[] args) {

        DLL<Point> dll = new DLL<Point>();

        Point p1 = new Point(1, 10);
        Point p2 = new Point(2, 20);
        Point p3 = new Point(3, 30);
        Point p4 = new Point(4, 40);
        Point p5 = new Point(5, 50);
        
        System.out.println("Testing add ...");
        dll.add(p1);
        dll.add(p2);
        dll.add(p3);
        dll.add(p4);
        dll.add(p5);
        
        System.out.println("Testing iterator ...");
        ListIterator<Point> iter = dll.listIterator();
        
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ... ");
        }
        System.out.println();
        
        System.out.println("Iterating backwards ...");
        while(iter.hasPrevious()) {
            System.out.print(iter.previous() + " ... ");
        }
        System.out.println();

        dll.remove(p1);
        System.out.println("remove p1");
        iter = dll.listIterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ... ");
        }
        System.out.println();
        while(iter.hasPrevious()) {
            System.out.print(iter.previous() + " ... ");
        }
        System.out.println();

        dll.remove(p5);
        System.out.println("remove p5");
        iter = dll.listIterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ... ");
        }
        System.out.println();
        while(iter.hasPrevious()) {
            System.out.print(iter.previous() + " ... ");
        }
        System.out.println();

        dll.remove(p3);
        System.out.println("remove p3");
        iter = dll.listIterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ... ");
        }
        System.out.println();
        while(iter.hasPrevious()) {
            System.out.print(iter.previous() + " ... ");
        }
        System.out.println();

        dll.remove(p2);
        System.out.println("remove p2");
        dll.remove(p4);
        System.out.println("remove p4");
        iter = dll.listIterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ... ");
        }
        System.out.println();
        while(iter.hasPrevious()) {
            System.out.print(iter.previous() + " ... ");
        }
        System.out.println();
    }
    
}