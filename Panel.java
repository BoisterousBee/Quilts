// Panel.java - Etude 7 - Oliver O'Connor - 6529968
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.geom.*;
import java.util.*;

public class Panel extends JPanel{
    public Queue<Double[]> order = new LinkedList<>();
    public Integer red = Quilts.getRGB().get(0)[0];
    public Integer green = Quilts.getRGB().get(0)[1];
    public Integer blue = Quilts.getRGB().get(0)[2];
    public Double size = Quilts.getSize();
    public Double scaledSize = 1000/size;
    public static Integer length = Quilts.getLength();
    public Double scale = Quilts.getScale().get(0) * scaledSize;
    public Double[] center = new Double[]{1020/2 * 1.0,1020/2 * 1.0};
    public Integer count = 1;
    public Integer counter = 0;

    Panel(){
        this.setPreferredSize(new Dimension(1020,1020));
    }

    public void paint(Graphics g){
        order = new LinkedList<>();
        red = Quilts.getRGB().get(0)[0];
        green = Quilts.getRGB().get(0)[1];
        blue = Quilts.getRGB().get(0)[2];
        count = 1;
        counter = 0;
        order.add(center);
        for (int i = 0; i < length; i++){
            scale = Quilts.getScale().get(i) * (scaledSize);
            red = Quilts.getRGB().get(i)[0];
            green = Quilts.getRGB().get(i)[1];
            blue = Quilts.getRGB().get(i)[2];
            for (int in=1; in<=(count); in++){
                painter(g);
            }
            counter++;
            power();
        }
    }
    
    public void painter(Graphics g){
        Double[] rect = order.peek();
        Rectangle2D.Double rectangle = new Rectangle2D.Double(rect[0]-(scale/2),rect[1]-(scale/2),scale,scale);
        Graphics2D g2D = (Graphics2D)g.create();
        g2D.setColor(new Color(red,green,blue));
        g2D.fill(rectangle);
        Double[] topLeft = new Double[]{rectangle.getMinX(),rectangle.getMinY()};
        Double[] topRight = new Double[]{rectangle.getMaxX(),rectangle.getMinY()};
        Double[] botLeft = new Double[]{rectangle.getMinX(),rectangle.getMaxY()};
        Double[] botRight = new Double[]{rectangle.getMaxX(),rectangle.getMaxY()};
        order.add(topLeft);
        order.add(topRight);
        order.add(botLeft);
        order.add(botRight);
        order.remove();
    }
    public void power(){
        count = (int)Math.pow(4.0,counter * 1.0);
    }

}