package tabs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

//This is simply an empty tab. In the future it will have a menu in the middle to add components to it, like a calculator.
public class BlankTab extends Tab
{
	public BlankTab(JTabbedPane tp)
	{
		JLabel filler = new JLabel("Nothing Here");
		filler.setHorizontalAlignment(JLabel.CENTER);
		super.content.setLayout(new GridLayout(1, 1));
		super.content.add(filler);
		super.con = tp;
	}

	public String getType()
	{
		return "blank";
	}	

}
