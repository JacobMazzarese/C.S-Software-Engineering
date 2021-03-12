import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The CanvasDisplay class serves the purpose of a visual representation
 * of the Canvas drawing classes. (0,0) of the canvas coordinate
 * system is the top-left corner. Down and right are increasing coordinate
 * values.
 * 
 * @author Brycon Carpenter
 * @version 0.1
 */

public class CanvasDisplay extends JPanel
{
    private final int DEFAULT_WIDTH = 400;
    private final int DEFAULT_HEIGHT = 400;
    
    private ArrayList<Integer[][]> shapes;
    private ArrayList<Color[]> colors;
    
    public JFrame frame;

    public CanvasDisplay(String title) {
        shapes = new ArrayList<Integer[][]>();
        colors = new ArrayList<Color[]>();
        frame = new JFrame(title);
        frame.getContentPane().add(this);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        frame.setVisible(true);
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        
        for (int i = 0; i < shapes.size(); i++) {
            Integer[][] points = shapes.get(i);
            
            int[] x = new int[points[0].length], y = new int[points[1].length];
            
            for (int j = 0; j < points[0].length; j++) {
                x[j] = points[0][j];
                y[j] = points[1][j];
            }
            
            g.setColor(colors.get(i)[0]);
            g.fillPolygon(x, y, points[0].length);
            g.setColor(colors.get(i)[1]);
            g.drawPolygon(x, y, points[0].length);
        }
    }
    
    /**
     * The key method for interfacing between the display and the
     * Canvas drawing classes. The information about the shape will
     * be passed from here to the List of drawable shapes and
     * will appear on the screen after the call.
     * 
     * @param sides - 2 Integer arrays (Must be Integer due to generics),
     *      representing x and y coordinates, respectively.
     *      The values should be in logical order, meaning the order should
     *      be as if you were drawing them with a pencil without picking it up.
     *      The points will be connected in the order they are provided.
     * @param colors - 2 Color values. The order should be {fillColor, line Color}
     *       the results may be unintentional if this convention is not followed.
     */
    public void addShape(Integer[][] sides, Color[] colors) {
        shapes.add(sides);
        this.colors.add(colors);
        repaint();
    }

    /**
     * Clears the display on the canvas. All previous shape data will
     * be lost.
     */
    public void clear() {
        shapes = new ArrayList<Integer[][]>();
        colors = new ArrayList<Color[]>();
    }

}
