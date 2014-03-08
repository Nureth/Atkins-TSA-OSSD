package coreWindow;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

//import coreWindow2.WriteVersion;
import tabs.*;

public class WindowInit extends JPanel 
{
	private static final long serialVersionUID = 1L;
	JTabbedPane tabbedPane = new JTabbedPane(); // The tabbed pane that is added to the JFrame
	int i = 0; // This is used to tell which tab to add a close button to

	public void drawFrame()
	/**
	 * This is the method that creates the "big" window, the primary user interface
	 */
	{
		Properties prop = new Properties();
		try {
			//load a properties file
			prop.load(new FileInputStream("Version.txt"));

		} catch (IOException ex) 
		{
			System.out.print("File not found");
		}
		//create the frame
		//WriteVersion.setVersion("1.1.0");
		JFrame frame = new JFrame("Lab Mate " + prop.getProperty("version"));

		//Change frame details
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(500,500);

		//Add the JPane that has tabs, starting out blank.	
		addPlusTab();
		frame.add(tabbedPane);
	}

	public void newTab(Tab tab, String title)
	{
		tab.title = title;
		tabbedPane.insertTab(title,null,tab.panel,null,tabbedPane.getTabCount()-1);
		new CloseTabButton(tabbedPane, tabbedPane.getTabCount()-2);
	}

	private void addPlusTab()
	{
		tabbedPane.addTab (null, null);
		FlowLayout f = new FlowLayout (FlowLayout.CENTER, 5, 0);

		// Make a small JPanel with the layout and make it non-opaque
		JPanel pnlTab = new JPanel (f);
		pnlTab.setOpaque (false);
		// Create a JButton for adding the tabs
		JButton plusTab = new JButton ();
		plusTab.setIcon(new PlusIcon());
		plusTab.setOpaque (false); //
		plusTab.setBorder (null);
		plusTab.setSize(10,10);
		plusTab.setContentAreaFilled (false);
		plusTab.setFocusPainted (false);

		plusTab.setFocusable (false);

		pnlTab.add (plusTab);

		tabbedPane.setTabComponentAt (tabbedPane.getTabCount () - 1, pnlTab);

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				String title = "Tab " + String.valueOf (tabbedPane.getTabCount ());
				newTab(new BlankTab(tabbedPane),title);
				tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-2);
			}
		};
		plusTab.setFocusable (false);
		plusTab.addActionListener (listener);
		tabbedPane.setVisible (true);	
	}
}