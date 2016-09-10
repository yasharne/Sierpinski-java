
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

/**
 *
 * @author yashar nesabian
 */
public class main extends JApplet {

    int in;

    @Override
    public void init() {
        while (true) {
            setSize(600, 600);
            in = Integer.parseInt(JOptionPane.showInputDialog("Enter Level:"));
            if (in >= 0 ) {
                break;
            }
        }

    }

    @Override
    public void paint(Graphics g) {
        int xPos[] = {0, getWidth() / 2, getWidth()};
        int yPos[] = {getHeight(), 0, getHeight()};

        drawSierpinski(g, in, xPos, yPos);

    }

    public void drawSierpinski(Graphics g, int in, int xPos[], int yPos[]) {
        
        drawTriangle(g, xPos, yPos);
        
        if (in >0) {
            int xP1[] = {xPos[0], midPoint(xPos[0], xPos[1]),midPoint(xPos[0], xPos[2])};
            int yP1[] = {yPos[0], midPoint(yPos[0], yPos[1]), midPoint(yPos[0], yPos[2])};
            drawSierpinski(g, in - 1, xP1, yP1);
            
            int xP2[] = {xPos[1], midPoint(xPos[1], xPos[0]), midPoint(xPos[1], xPos[2])};
            int yP2[] = {yPos[1], midPoint(yPos[1], yPos[0]), midPoint(yPos[1], yPos[2])};
            drawSierpinski(g, in - 1, xP2, yP2);
            
            int xP3[] = {xPos[2], midPoint(xPos[2], xPos[0]), midPoint(xPos[1], xPos[2])};
            int yP3[] = {yPos[2], midPoint(yPos[2], yPos[0]), midPoint(yPos[1], yPos[2])};
            drawSierpinski(g, in - 1, xP3, yP3);
        }

    }

    public void drawTriangle(Graphics g, int xPos[], int yPos[]) {
        g.drawPolygon(xPos, yPos, xPos.length);
    }

    public int midPoint(int p1, int p2) {
        return (p1 + p2) / 2;
    }
}
