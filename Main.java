public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(5, 2, 3);

        System.out.println("Circle1: " + circle);

        double area = circle.area();
        System.out.println("Area of Circle1: " + area);

        double circumference = circle.circumference();
        System.out.println("Circumference of Circle1: " + circumference);

        Circle circle2 = circle.createCircleWithNewRadius(10);

        System.out.println("Circle2 (new radius, same center): " + circle2);

        boolean isInside = circle.isInside(3, 3);
        System.out.println("Point (3,3) is inside Circle1: " + isInside);

        double sectorArea = circle.areaOfSector(Math.PI / 2);
        System.out.println("Area of a 90-degree sector of Circle1: " + sectorArea);

        circle.addChord(1, 1, 4, 4);
        circle.addChord(2, 2, 3, 5);
        circle.addChord(0, 0, 5, 5);

        System.out.println("Initial Chords:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Chord " + i + ": " + circle.getChord(i));
        }

        System.out.println("\nUpdating Chord 1:");
        circle.updateChord(1, 3, 3, 6, 6);
        System.out.println("Chord 1 after update: " + circle.getChord(1));

        System.out.println("\nRetrieving Chord 2:");
        Circle.Chord chord = circle.getChord(2);
        if (chord != null) {
            System.out.println("Chord 2: " + chord);
        }

        System.out.println("Ch");
        Circle ell = new Ellipse(9, 5, 2, 3);
        ell.addChord(1, 1, 4, 4);
        for (int i = 0; i < 1; i++) {
            System.out.println("Chord " + i + ": " + ell.getChord(i));
        }
    }


}
