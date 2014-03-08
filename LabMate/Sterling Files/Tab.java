package tabs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

//This class is simply used in the newTab() method of the WindowInit class. 
public class Tab{
	
	/***********************Panes/Frames***********************/
	JPanel content = new JPanel();
	public JPanel panel = new JPanel(false);
	JTabbedPane con;
	JFrame newFrame;
	/***********************Variables***********************/
	private boolean independant = false;	
	public String title = "Tab";
	/***********************Constructor***********************/
	public Tab(){
		panel.setLayout(new BorderLayout());
		panel.add(createMenu(), BorderLayout.NORTH);
		panel.add(content);
	}
	/***********************Adds Top Menu (File, Edit, etc.)***********************/
	private JMenuBar createMenu(){
		//JMenu
		JMenuBar menuBar = new JMenuBar();

		//'Tabs' of the menu
		JMenu menuFile = new JMenu("File");
		JMenu menuEdit = new JMenu("Edit");
		JMenu menuHelp = new JMenu("Help");
		JMenu menuLabMate = new JMenu("LabMate");

		/*
    JMenuItem menuItem = new JMenuItem(new AbstractAction("My Menu Item") {
        public void actionPerformed(ActionEvent e) {
            // Button pressed logic goes here
        }
    });
		 */

		JMenuItem menuFileExit = new JMenuItem(new AbstractAction("Exit"){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JMenuItem menuFileSave = new JMenuItem("Save");
		JMenuItem menuFileLoad = new JMenuItem("Load");

		JMenuItem menuFileCloseTab = new JMenuItem(new AbstractAction("Close"){
			public void actionPerformed(ActionEvent e) {
				if (!independant)
					closeTab();
				else
					popIn();
			}
		});

		JMenuItem menuLabMateNewTab = new JMenuItem("New Tab");
		JMenuItem menuLabMatePopOut = new JMenuItem(new AbstractAction("Pop"){
			public void actionPerformed(ActionEvent e) {
				if (!independant)
					popOut();
				else
					popIn();
			}
		});

		//put it all together
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuHelp);
		menuBar.add(menuLabMate);
		menuFile.add(menuFileExit);
		menuFile.add(menuFileSave);
		menuFile.add(menuFileLoad);
		menuFile.add(menuFileCloseTab);
		menuLabMate.add(menuLabMateNewTab);
		menuLabMate.add(menuLabMatePopOut);
		
		// shift to the right
	    menuBar.add(Box.createGlue());

	    // this button will be shifted right on the menubar
	    Action actionPop = new AbstractAction("Pop") {
	       public void actionPerformed(ActionEvent evt) {
	    	   if (!independant)
					popOut();
				else
					popIn();
	       }
	    };
	    menuBar.add(new JButton(actionPop));

		return menuBar;
	}
	/***********************Closes Tab When it is in the main window***********************/
	public void closeTab(){
		if (con.indexOfComponent(panel)!=-1)
			con.remove(con.indexOfComponent(panel));
	}
	/***********************Creates a PopOut Window of the content***********************/
	private void popOut(){
		newFrame = new JFrame(title);
		newFrame.setSize(500,500);
		newFrame.setVisible(true);
		newFrame.setContentPane(panel);
		independant = true;
		closeTab();
	}
	/***********************Deletes the popout window and adds a tab to the main window***********************/
	private void popIn(){
		con.insertTab(title, null, panel, null, con.getTabCount()-1);
		new CloseTabButton(con, con.getTabCount()-2);
		newFrame.dispose();
		independant = false;
	}
}
