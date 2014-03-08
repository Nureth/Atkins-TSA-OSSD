package tabs;

import java.awt.GridLayout;

import javax.swing.JLabel;

//This is simply an empty tab. In the future it will have a menu in the middle to add components to it, like a calculator.
public class BlankTab extends Tab
{
	public BlankTab()
	{
	JLabel filler = new JLabel("Nothing Here");
    filler.setHorizontalAlignment(JLabel.CENTER);
    super.panel.setLayout(new GridLayout(1, 1));
    super.panel.add(filler);
	}
	
	public String getType()
	{
		return "blank";
	}
}
