package mert;

public class Triangle extends Shape {

    public int x;
    public int y;

    public Triangle(int x, int y, int colorNum, String name) throws UnknownColorException, WrongNameException {
        super(colorNum, name);
        if(("Triangle".equals(name.substring(0, name.length() - 4))) && (colorNum >= 0) && (colorNum <= Colors.arrayLocation-1)){
            this.x = x;
            this.y = y;
        }else if(!"Triangle".equals(name.substring(0, name.length() - 4))){
            throw new WrongNameException("Naming is not valid.");
        }else{
            throw new UnknownColorException("Color is not valid.");
        }
    }

    public double area() {
        /**
         *         Triangle is assumed to be equilateral triangle
         *     .    • this is the vector we know 
         *     .   //\         if we multiply ((x*2)*y)/2 we get the area
         *     .  //  \        here x*2 is the bottom line length
         *    y. //    \       y is h
         *     .//      \      area of triangle is bottom line * h / 2
         *     //.x._____\
         */
        return (x*2)*y/2;
    }

    public double circumference() {
        return 3*Math.sqrt(x*x+y*y);
    }

    public void info() {
        System.out.println(name + ", equilateral triangle, edge length: " + (int)Math.sqrt(x*x+y*y) + ", color: " + Colors.getColor(colorNum) + ".");
    }
}
