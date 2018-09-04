package applet;

import java.awt.*;

import javax.swing.*;
 
public class snow extends JApplet
{
    int level = 0;
 
    public void init()
    {
        String levelStr = JOptionPane.showInputDialog("Enter the depth of recursion");
 
        level = Integer.parseInt(levelStr);
        setBackground(Color.cyan);
    }
 
    public void paint(Graphics g)
    {
    	//Object color;
		g.setColor(Color.blue);
		//g.
        drawSnow(g,level,20,280,280,280);
        drawSnow(g,level,280,280,150,20);
        drawSnow(g,level,150,20,20,280);
        
    }
 
    private void drawSnow (Graphics g, int lev, int x1, int y1, int x5, int y5)
   {
          int deltaX, deltaY, x2, y2, x3, y3, x4, y4;
 
          if (lev == 0)
          {
 
              g.drawLine(x1, y1, x5, y5);
          }
          else
          {
                deltaX = x5 - x1;
                deltaY = y5 - y1;
 
                x2 = x1 + deltaX / 3;
                y2 = y1 + deltaY / 3;
 
                x3 = (int) (0.5 * (x1+x5) + Math.sqrt(3) * (y1-y5)/6);
                y3 = (int) (0.5 * (y1+y5) + Math.sqrt(3) * (x5-x1)/6);
 
                x4 = x1 + 2 * deltaX /3;
                y4 = y1 + 2 * deltaY /3;
 
                drawSnow (g,lev-1, x1, y1, x2, y2);
                drawSnow (g,lev-1, x2, y2, x3, y3);
                drawSnow (g,lev-1, x3, y3, x4, y4);
                drawSnow (g,lev-1, x4, y4, x5, y5);
            }
        }
  
}