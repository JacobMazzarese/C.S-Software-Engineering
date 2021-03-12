 import java.awt.Color;

/* Is it possible that our new applications could be less efficient at runtime? Explain
 *	Yes, we have added another step, the adapter, that has to run and decide which code 
 *	to execute could definitely be less efficient at runtime. 
 * What class will be the Adapter? The Adaptee?
 *
 *	Our adapter class would be MyCanvasAdapter and the adaptee class would be MyNewCanvas
 *
 * What is the company saving (in terms of work) by using this pattern?
 *
 *	Rather than creating new code, we can use an adapter that allows the interface of an 
 *	existing class to be used as another interface.
 *
 *  In one sentence, state the responsibility of the MyCanvasAdapter class.
 *
 *	MyCanvasAdapter class takes our new MyNewCanvas object and converts it so it can match
 *	the MyCanvas interface requested by the client. 
 *
 *  Why does the adapter need to use two fields, lineColor and fillColor? (Ask me if you need help.)
 * 
 *  The adapter pattern needs the two fields lineColor and fillColor because the target interface
 *  that we are converting two requires the setLineColor(Color rgb) and the setFillColor(Color rgb)
 *  methods that assign a new color to both fields. 
 *
 *  Copy the three lines of code for drawSquare method into this comment. Line by line, describe what the method does.
 *
 *       Integer[] xCoords = {xPosition, xPosition + length, xPosition + length, xPosition};
 *       Integer[] yCoords = {yPosition, yPosition, yPosition + length, yPosition + length};
 *       Color[] colors = {fillColor, lineColor};
 *
 *	    This method creates a new square to be displayed by our CanvasDisplay method. The first and second lines of code
 *	    utilize parallel arrays which means that each value in position n of the xCoords array relates with that same position
 *	    in the yCoords array (in this case x and y coordinate points for a graph). As you can see we have four points in each
 *	    array to coordinate with the four corners of a square. The final array of type Color represents the color of the border
 *	    of the square and the fill color of it to be printed. 
 *
 */

 /* The difficult method to adapt for the new canvas interface: drawing a circle
 * 
 * Using simple trigonometry and some functions from the Math class, you can 
 * compute the coordinates of some large number (say, 360) of evenly spaced 
 * points around the radius of the circle in a loop:
 * for each value of theta:
 *  x = xPosition + radius * cos(theta)
 *  y = yPosition + radius * sin(theta)
 * You would then pass the resulting xCoords and yCoords arrays to 
 * canvas.drawShape(), along with the number of points and the line and fill 
 * colors.
 * 
 */

public class MyCanvasAdapter implements MyCanvas
{
    private MyNewCanvas canvas;
    private Color lineColor;
    private Color fillColor;

    public MyCanvasAdapter(MyNewCanvas canvas) {
        this.canvas = canvas;
        lineColor = Color.BLACK;
        fillColor = Color.WHITE;
    }

    public void clear() {
        canvas.clear();
    }

    public void setLineColor(Color rgb) {
        lineColor = rgb;
    } 

    public void setFillColor(Color rgb){
        fillColor = rgb;
    }

    public void drawSquare(int xPosition, int yPosition, int length) {
        // x and y give the top-left corner
        int[] xCoords = {xPosition, xPosition + length,
                xPosition + length, xPosition};
        int[] yCoords = {yPosition, yPosition,
                yPosition + length, yPosition + length};
        canvas.drawShape(xCoords, yCoords, 4, lineColor, fillColor);
    }

    public void drawRectangle(int xPosition, int yPosition, int topLength, int sideLength) {
        // x and y give the top-left corner
        // sideLength and topLength seem like they should be switched, but this
        // way the output matches MyOldCanvas, which is the point of the pattern
        int[] xCoords = {xPosition, xPosition + sideLength,
                xPosition + sideLength, xPosition};
        int[] yCoords = {yPosition, yPosition,
                yPosition + topLength, yPosition + topLength};
        canvas.drawShape(xCoords, yCoords, 4, lineColor, fillColor);
    }

    public void drawRightTriangle(int xPosition, int yPosition, int verticalLength,
            int horizontalLength) {
        // verticalLength and horizontalLength can be positive or negative
        System.out.println("Drawing a RightTriangle \n at x: " + xPosition 
                            + "y: " + yPosition + "\n verticalLength: " + verticalLength
                            + " horizontalLength: " + horizontalLength);
        int[] xCoords = {xPosition, xPosition, xPosition + horizontalLength};
        int[] yCoords = {yPosition, yPosition + verticalLength, yPosition};
        Color[] colors = {fillColor, lineColor};
        //canvas.addShape(new Integer[][]{xCoords, yCoords},colors);
        canvas.drawShape(xCoords, yCoords, 3, lineColor, fillColor);
    }

    public void drawTriangle (int[] xPosition, int[] yPosition) {
        // each array has 3 coordinate points for the 3 corners of the Triangle
        // each array has 3 coordinate points for the 3 corners of the Triangle
        System.out.println("Drawing a Triangle\n at xPosition[0]: "
                + xPosition[0] + " yPosition[0]: " + yPosition[0]
                + "\n xPosition[1]: " + xPosition[1] + " yPosition[1]: "
                + yPosition[1] + "\n xPosition[2]: " + xPosition[2]
                + " yPosition[2]: " + yPosition[2] + "\n lineColor: "
                + lineColor + " fillColor: " + fillColor);
        
        Integer[][] sides = {{xPosition[0], xPosition[1], xPosition[2]}, {yPosition[0], yPosition[1], yPosition[2]}};
        Color [] colors = {fillColor, lineColor};
        //canvas.addShape(sides, colors);
        canvas.drawShape(xPosition, yPosition, 3, lineColor, fillColor);

    }

    public void drawLine (int xStart, int yStart, int xEnd, int yEnd) {
	 System.out.println("Drawing a Line\n from (" + xStart + " , " + yStart
                + ") to (" + xEnd + " , " + yEnd + ")" + " lineColor: "
                + lineColor);
        Integer[][] sides = {{xStart, xEnd}, {yStart, yEnd}};
        Color [] colors = {fillColor, lineColor};
        //canvas.addShape(sides, colors);
        int[] xcor = {xStart,xEnd};
        int[] ycor = {yStart,yEnd};
        canvas.drawShape(xcor, ycor, 1, lineColor, fillColor);

    }
}
