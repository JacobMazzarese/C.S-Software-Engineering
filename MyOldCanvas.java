import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The MyCanvas Class is a legacy drawing class. (0,0) of the canvas coordinate
 * system is the top-left corner. Down and right are increasing coordinate
 * values.
 * 
 * @author Dr. Ray Russell, Brycon Carpenter
 * @version 0.3
 */
public class MyOldCanvas implements MyCanvas
{
    private Color lineColor;
    private Color fillColor;
    
    private CanvasDisplay canvas;
    
    public MyOldCanvas()
    {
        System.out.println("Constructing a MyCanvas.");
        lineColor = Color.BLACK; // black
        fillColor = Color.WHITE; // white
        canvas = new CanvasDisplay("MyCanvas Display");
    }

    public void clear()
    {
        System.out.println("Clearing the Canvas.");
        canvas.clear();
    }

    public void setLineColor(Color rgb)
    {
        System.out.println("Setting the Line Color to " + rgb + ".");
        lineColor = rgb;
    }

    public void setFillColor(Color rgb)
    {
        System.out.println("Setting the Fill Color to " + rgb + ".");
        fillColor = rgb;
    }

    public void drawSquare(int xPosition, int yPosition, int length)
    {
        // x and y give the top-left corner
        System.out.println("Drawing a Square\n x: " + xPosition + " y: "
                + yPosition + " length: " + length + "\n lineColor: "
                + lineColor + " fillColor: " + fillColor);
        
        Integer[] xCoords = {xPosition, xPosition + length, xPosition + length, xPosition};
        Integer[] yCoords = {yPosition, yPosition, yPosition + length, yPosition + length};
        Color[] colors = {fillColor, lineColor};
        canvas.addShape(new Integer[][]{xCoords, yCoords}, colors);
        
    }

    public void drawRectangle(int xPosition, int yPosition, int topLength,
            int sideLength)
    {
        // x and y give the top-left corner
        System.out.println("Drawing a Rectangle\n at x: " + xPosition + " y: "
                + yPosition + "\n topLength: " + topLength + " sideLength: "
                + sideLength + "\n lineColor: " + lineColor + " fillColor: "
                + fillColor);
        
        Integer[] xCoords = {xPosition, xPosition + sideLength, xPosition + sideLength, xPosition};
        Integer[] yCoords = {yPosition, yPosition, yPosition + topLength, yPosition + topLength};
        Color[] colors = {fillColor, lineColor};
        canvas.addShape(new Integer[][]{xCoords, yCoords}, colors);
        
    }

    public void drawRightTriangle(int xPosition, int yPosition,
            int verticalLeg, int horizontalLeg)
    {
        // verticalLeg and horizontalLeg can be positive or negative to give any
        // orientation
        // to the Right
        System.out.println("Drawing a RightTriangle\n at x: " + xPosition
                + " y: " + yPosition + "\n verticalLeg: " + verticalLeg
                + " horizontalLeg: " + horizontalLeg + "\n lineColor: "
                + lineColor + " fillColor: " + fillColor);
        
        Integer[] xCoords = {xPosition, xPosition, xPosition + horizontalLeg};
        Integer[] yCoords = {yPosition, yPosition + verticalLeg, yPosition};
        Color[] colors = {fillColor, lineColor};
        canvas.addShape(new Integer[][]{xCoords, yCoords}, colors);
    }

    public void drawTriangle(int[] xPosition, int[] yPosition)
    {
        // each array has 3 coordinate points for the 3 corners of the Triangle
        System.out.println("Drawing a Triangle\n at xPosition[0]: "
                + xPosition[0] + " yPosition[0]: " + yPosition[0]
                + "\n xPosition[1]: " + xPosition[1] + " yPosition[1]: "
                + yPosition[1] + "\n xPosition[2]: " + xPosition[2]
                + " yPosition[2]: " + yPosition[2] + "\n lineColor: "
                + lineColor + " fillColor: " + fillColor);
        
        Integer[][] sides = {{xPosition[0], xPosition[1], xPosition[2]}, {yPosition[0], yPosition[1], yPosition[2]}};
        Color [] colors = {fillColor, lineColor};
        canvas.addShape(sides, colors);
    }

    public void drawLine(int xStart, int yStart, int xEnd, int yEnd)
    {
        System.out.println("Drawing a Line\n from (" + xStart + " , " + yStart
                + ") to (" + xEnd + " , " + yEnd + ")" + " lineColor: "
                + lineColor);
        Integer[][] sides = {{xStart, xEnd}, {yStart, yEnd}};
        Color [] colors = {fillColor, lineColor};
        canvas.addShape(sides, colors);
    }
}
