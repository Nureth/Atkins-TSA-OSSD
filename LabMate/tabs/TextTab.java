package tabs;

import java.awt.GridLayout;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


//This tab will be used primarily for notes and observations. It is simply a text editor, with a fancy background. 
public class TextTab extends Tab
{	
	private BufferedReader reader;


	public TextTab() throws IOException
	{
		reader = new BufferedReader(new FileReader("ChangeLog.txt"));
		String line = null;
		String completeText ="";
		while ((line = reader.readLine()) != null) {
		    completeText += (line + "\n");
		}
		TextArea filler = new TextArea(completeText,4,30,TextArea.SCROLLBARS_VERTICAL_ONLY);
        super.panel.setLayout(new GridLayout(1, 1));
        super.panel.add(filler);
	}
	
	
	public String getType()
	{
		return "text";
	}
}
