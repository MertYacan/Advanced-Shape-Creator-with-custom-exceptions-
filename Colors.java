package mert;

import java.util.HashMap;
public class Colors {
    //I change the size of array by 5 everytime it's full, to improve performance
    //so i need one variable to find how many color options there are
    static int arrayLocation = 1;
    static String Colors[] = new String[1];
    static HashMap<Integer, String> colors = new HashMap<Integer, String>();

    public static void addColor(String Color) {
        if(colors.containsValue(Color)){
            System.out.println("A color cannot be added multiple times!");
        }else{
        colors.put(arrayLocation++, Color);
        }
    }
    
    public static String getColor(int a){
        return colors.get(a);
    }
    
    public static int getRandomColor(){
        return (int)((arrayLocation-1)*Math.random()+1);
    }

}
