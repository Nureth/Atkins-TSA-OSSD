package coreWindow;

import java.io.IOException;

import tabs.*;

public class LabInit {
	public static void main(String args[]) throws IOException
	{
	WindowInit window = new WindowInit();
	
	window.drawFrame();
	window.newTab(new TextTab(), "Change Log");//Add a new text tab
	}
}
