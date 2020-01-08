package mert;
public abstract class Shape {
    public String name;
    public int colorNum;
    
    Shape(int colorNum, String name){
        this.colorNum = colorNum;
        this.name = name;
    }
    
    public abstract double area();
    public abstract double circumference();
    public abstract void info();
}
