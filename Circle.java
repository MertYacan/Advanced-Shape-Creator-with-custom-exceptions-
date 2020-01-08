package mert;
public class Circle extends Shape {
    public int r;
    
    public Circle(int r, int colorNum, String name) throws UnknownColorException, WrongNameException{
        super(colorNum, name);
        if(("Circle".equals(name.substring(0, name.length() - 4))) && (colorNum >= 0) && (colorNum <= Colors.arrayLocation-1)){
            this.r = r;
        }else if(!"Circle".equals(name.substring(0, name.length() - 4))){
            throw new WrongNameException("Naming is not valid.");
        }else{
            throw new UnknownColorException("Color is not valid.");
        }
    }

    public double area() {
        return Math.PI*r*r;
    }

    public double circumference() {
        return (Math.PI)*r*2;
    }
    public void info(){
        System.out.println(name + ", circle, r: " + r + ", color: " + Colors.getColor(colorNum) + ".");
    }
}
