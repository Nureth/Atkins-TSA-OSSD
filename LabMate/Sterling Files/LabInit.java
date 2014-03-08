package coreWindow;

import java.io.IOException;
import tabs.*;

public class LabInit {
	public static void main(String args[]) throws IOException
	{
	WindowInit window = new WindowInit();
	
	window.drawFrame();
	window.newTab(new BlankTab(window.tabbedPane),"Test Tab");
	}
}
