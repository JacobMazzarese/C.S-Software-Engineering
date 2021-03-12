import java.awt.Color;
/* 
 * This code uses the legacy MyCanvas class.
 * 
 * @author Dr. Ray Russell 
 * @version 0.2
 */
public class Client
{
    static public void main(String[] args) {
        //MyOldCanvas can = new MyOldCanvas();
        MyCanvas canvas = new MyCanvasAdapter(new MyNewCanvas());
        canvas.clear();
        canvas.setLineColor(Color.BLACK);
        canvas.drawSquare(20, 40, 50);
        canvas.drawRectangle(15, 35, 18, 36);
        //canvas.setFillColor(Color.GREEN);
        //canvas.drawRightTriangle(88, 52, 20, -10);
        //canvas.drawTriangle(new int[] {10, 20, 30}, new int[] {0, 40, 0});
        //canvas.drawLine(50, 70, 10, 49);
    }
}
