import java.awt.Color;
public interface MyCanvas {
    
    public void clear();
    public void setLineColor(Color rgb);
    public void setFillColor(Color rgb);
    public void drawSquare(int xPosition, int yPosition, int length);
    public void drawRectangle(int xPosition, int yPosition, int topLength, int sideLength);
    public void drawRightTriangle(int xPosition, int yPosition, int verticalLength, int horizontalLength);
    public void drawTriangle(int[] xPosition, int[] yPosition);
    public void drawLine(int xStart,int yStart,int xEnd, int yEnd);
}
