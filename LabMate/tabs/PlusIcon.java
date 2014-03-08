package tabs;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class PlusIcon implements Icon {
	  public void paintIcon(Component c, Graphics g, int x, int y) {
		    g.setColor(Color.RED);
		    g.drawLine(5,getIconHeight()/2,getIconWidth()-5,getIconHeight()/2);
		    g.drawLine(getIconWidth()/2, 5,getIconWidth()/2,getIconHeight()-5);
		  }
		  public int getIconWidth() {
		    return 17;
		  }
		  public int getIconHeight() {
		    return 17;
		  } 

}
