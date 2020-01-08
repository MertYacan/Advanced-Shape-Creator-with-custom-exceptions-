package mert;

public class Rectangle extends Shape{
    public int x;
    public int y;
    
    public Rectangle(int x, int y, int colorNum, String name) throws UnknownColorException, WrongNameException{
        super(colorNum, name);
        if(("Rectangle".equals(name.substring(0, name.length() - 4))) && (colorNum >= 0) && (colorNum <= Colors.arrayLocation-1)){
            this.x = x;
            this.y = y;
        }else if(!"Rectangle".equals(name.substring(0, name.length() - 4))){
            throw new WrongNameException("Naming is not valid.");
        }else{
            throw new UnknownColorException("Color is not valid.");
        }
    }
    
    public double area(){
        return x*y;
    }
    public double circumference(){
        return 2*(x+y);
    }
    public void info(){
        System.out.println(name + ", rectangle, x: " + x + ", y: " + y + ", color: " + Colors.getColor(colorNum) + ".");
    }
}
