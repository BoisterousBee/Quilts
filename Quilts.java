// Quilts.java - Etude 7 - Oliver O'Connor - 6529968
import java.util.*;
public class Quilts{
    public static ArrayList<Integer[]> rgb = new ArrayList<Integer[]>();
    public static ArrayList<Double> scale = new ArrayList<Double>();
    public static Integer length = 0;
    public static Double size = 0.0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> squares = new ArrayList<String>();
        while (sc.hasNextLine()){
            length++;
            squares.add(sc.nextLine());
        }
        for (String s : squares){
            Integer[] numbers = new Integer[3];
            String[] strings = s.split("\\s+");
            for (int i = 1; i<strings.length;i++){
                numbers[i-1] = Integer.parseInt(strings[i]);
            }
            rgb.add(numbers);
            Double number = Double.parseDouble(strings[0]);
            scale.add(number);
        }
        for (int i =0 ; i<length;i++){
            size = (size + (scale.get(i) * 1.0));
        }
        new Frame();
    }
    public static ArrayList<Integer[]> getRGB(){
        return rgb;
    }
    public static ArrayList<Double> getScale(){
        return scale;
    }
    public static Integer getLength(){
        return length;
    }
    public static Double getSize(){
        return size;
    }
}