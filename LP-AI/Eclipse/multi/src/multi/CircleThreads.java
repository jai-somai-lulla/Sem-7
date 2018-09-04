package multi;
import java.awt.*;
import javax.swing.JFrame;
public class CircleThreads extends JFrame implements Runnable
{

	private Thread red,yellow,green;
	private int rx,yx,gx;
	public CircleThreads()
	{
		red=new Thread(this,"RED");
		yellow=new Thread(this,"YELLOW");
		green=new Thread(this,"GREEN");
		red.start();
		yellow.start();
		green.start();
		this.setVisible(true);
		this.setSize(500,500);
	}
	public void run() 
	{
		while(true)
		{
			try
			{
				if(Thread.currentThread()==red)
				{
					synchronized(this)
					{
						if(rx==300)
							wait();
					}
					rx++;
					Thread.sleep(10);
				}

				if(Thread.currentThread()==yellow)
				{
					synchronized(this)
					{
						if(yx==300)
							wait();
					}
					yx++;
					Thread.sleep(30);
				}

				if(Thread.currentThread()==green)
				{
					synchronized(this)
					{
						if(gx==400)
							wait();
					}
					gx++;
					Thread.sleep(50);
				}
				repaint();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		g.setColor(Color.RED);
		g.fillOval(rx, 100, 50, 50);

		g.setColor(Color.YELLOW);
		g.fillOval(yx, 200, 50, 50);

		g.setColor(Color.GREEN);
		g.fillOval(gx, 300, 50, 50);
	}

	public static void main(String[] args) 
	{
		new CircleThreads();
	}

}