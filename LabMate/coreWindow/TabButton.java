package coreWindow;

import java.awt.BasicStroke;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class TabButton extends JButton implements ActionListener 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TabButton()
	{
		this.setText("X");
		setContentAreaFilled(false);
		this.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
			} 
		});

	}
	
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        //shift the image for pressed buttons
        if (getModel().isPressed()) {
            g2.translate(1, 1);
        }
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLACK);
        if (getModel().isRollover()) {
            g2.setColor(Color.MAGENTA);
        }
        int delta = 6;
        g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
        g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
        g2.dispose();
    }


	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1,getWidth()/4-1,getWidth()/4-1);
	}
	
	Shape shape;
	public boolean contains(int x, int y) {
		if (shape == null || 
				!shape.getBounds().equals(getBounds())) {
			shape = new Rectangle.Float(0, 0, getWidth(), getHeight());
		}
		return shape.contains(x, y);
	}

	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("close clicked");
  	}


}


