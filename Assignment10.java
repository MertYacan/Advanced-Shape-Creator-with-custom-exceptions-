   package mert;

import java.util.ArrayList;
public class Assignment10 {

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            // swapping
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //lets add some colors
        Colors.addColor("Blue");
        Colors.addColor("Red");
        Colors.addColor("Green");
        Colors.addColor("Purple");
        Colors.addColor("Black");
        Colors.addColor("White");
        //more can be added
        //Colors.addColor("Anothercolor");
        System.out.println("Creating 100 random shapes:\n");
        ArrayList<Shape> sekillerr = new ArrayList<Shape>();

        int circle = 0;
        int rectangle = 0;
        int triangle = 0;
        for (int i = 0; i < 100; i++) {
            double randomizer = Math.random();
            try {
                if (randomizer < 0.33) {
                    rectangle++;
                    String nameNumber = String.format("%03d", rectangle);
                    //Rectangle- + XXX format
                    String name = "Rectangle-" + nameNumber;
                    sekillerr.add(new Rectangle((int) (Math.random() * 500), (int) (Math.random() * 500), Colors.getRandomColor(), name));
                } else if (randomizer < 0.66) {
                    circle++;
                    String nameNumber = String.format("%03d", circle);
                    //Circle- + XXX format
                    String name = "Circle-" + nameNumber;
                    sekillerr.add(new Circle((int) (Math.random() * 300), Colors.getRandomColor(), name));
                } else {
                    triangle++;
                    String nameNumber = String.format("%03d", triangle);
                    //Triangle- + XXX format
                    String name = "Triangle-" + nameNumber;
                    sekillerr.add(new Triangle((int) (Math.random() * 500), (int) (Math.random() * 500), Colors.getRandomColor(), name));
                }
                sekillerr.get(i).info();
            } catch (UnknownColorException | WrongNameException A) {
                System.out.println(A.getMessage());
                i--;
            }
        }

        double totArea = 0;
        for (int i = 0; i < 100; i++) {
            totArea = sekillerr.get(i).area() + totArea;
        }
        System.out.println("Number of circles:" + circle);
        System.out.println("Number of rectangles:" + rectangle);
        System.out.println("Number of triangles:" + triangle);
        System.out.println("\nTotal Area: " + (int) totArea);
        System.out.println("Average Area: " + (int) totArea / 100);

        System.out.println("\nNumber of shapes by every color:");
        for (int i = 1; i < Colors.arrayLocation; i++) {
            int tempCircle = 0;
            int tempRectangle = 0;
            int tempTriangle = 0;
            System.out.println(Colors.getColor(i) + ":");
            for (int j = 0; j < 100; j++) {
                if (sekillerr.get(j).colorNum == i) {
                    if (sekillerr.get(j).getClass().equals(Circle.class)) {
                        tempCircle++;
                    } else if (sekillerr.get(j).getClass().equals(Rectangle.class)) {
                        tempRectangle++;
                    } else if (sekillerr.get(j).getClass().equals(Triangle.class)) {
                        tempTriangle++;
                    }
                }
            }
            System.out.println("Number of circles:" + tempCircle);
            System.out.println("Number of rectangles:" + tempRectangle);
            System.out.println("Number of triangles:" + tempTriangle);
            System.out.println("Total:" + (tempCircle + tempRectangle + tempTriangle) + "\n");
        }

        int howmanyred = 0;
        for (int i = 0; i < 100; i++) {
            if (sekillerr.get(i).colorNum == 2) {
                howmanyred++;
            }
        }
        Shape[] red = new Shape[howmanyred];
        int redLoc = 0;
        for (int i = 0; i < 100; i++) {
            if (sekillerr.get(i).colorNum == 2) {
                red[redLoc++] = sekillerr.get(i);
            }
        }

        for (int i = 0; i < red.length; i++) {
            Shape min = red[i];
            int minId = i;
            for (int j = i + 1; j < red.length; j++) {
                if (red[j].area() < min.area()) {
                    min = red[j];
                    minId = j;
                }
            }
            // swapping
            Shape temp = red[i];
            red[i] = min;
            red[minId] = temp;
        }
        System.out.println("Red shapes:");
        for (int i = 0; i < red.length; i++) {
            System.out.println(red[i].name + " is red and has area of: " + (int) red[i].area());
        }

        Shape longest = sekillerr.get(0);
        for (int i = 1; i < 100; i++) {
            if (sekillerr.get(i).circumference() > longest.circumference()) {
                longest = sekillerr.get(i);
            }
        }
        System.out.println("\nThe shape with biggest circumference is: " + longest.name + " and it's circumference is: " + (int) longest.circumference());

        System.out.println("\nNow lets try to construct some objects with wrong names and colorNums. \nThere are " + (Colors.arrayLocation) + " colors added and maximum colorNum for the " + (Colors.arrayLocation) + "th number is: " + (Colors.arrayLocation - 1) + (".\nSo lets try to constuct a rectangle with colorNum = 10."));
        int colorNumA = 10;
        try {
            Rectangle a = new Rectangle(999, 999, colorNumA, "Rectangle-101");
        } catch (UnknownColorException | WrongNameException A) {
            System.out.println(A.getMessage() + " Try another colorNum than " + colorNumA + ".");
        }
        
        System.out.println("\nLets try to construct a circle with name Cember_101.");
        String nameB = "Cember_101";
        try {
            Rectangle a = new Rectangle(999, 999, Colors.getRandomColor(), nameB);
        } catch (UnknownColorException | WrongNameException A) {
            System.out.println(A.getMessage() + " Try another name than " + nameB + ".");
        }
    }

}
