package unitConverter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Converter 
{
	public static void main(String[] args)
	{
		Prefix[] prefixes = {new Prefix(9, "Giga", "G"),
							new Prefix(6, "Mega", "M"),
							new Prefix(3, "Kilo", "k"),
							new Prefix(0, "", ""),
							new Prefix(-3, "mili", "m"),
							new Prefix(-6, "micro", "µ"),
							new Prefix(-9, "nano", "n")};
		Temperature[] temperatures ={new Temperature("Kelvin", "K", 1, 0, 0),
									new Temperature("Celsius", "°C", 1, 273.15, -273.15),
									new Temperature("Fahrenheit", "°F", .55555555555555555555555555555, 255.372222222222222222222222222, -459.67),
									new Temperature("Rankine", " °R", .5555555555555555555555555555, 0, 0)};
		Unit[] lengths = {new Unit("meter", "m", true, 1609.34, Unit.LENGTH), 
						new Unit("foot", "ft", false, 5280, Unit.LENGTH),
						new Unit("inch", "in", false, 63360, Unit.LENGTH),
						new Unit("yard", "yd", false, 1760, Unit.LENGTH),
						new Unit("mile", "mi", false, 1, Unit.LENGTH)};
		Unit[] masses = {new Unit("gram", "g", true, 1, Unit.MASS),
						new Unit("avoirdupois pound", "lb avdp", false, .00220462262185, Unit.MASS)};
		Unit[] times = {new Unit("second", "s", true, 604800, Unit.TIME),
						new Unit("minute", "min", false, 10080, Unit.TIME),
						new Unit("hour", "hr", false, 168, Unit.TIME),
						new Unit("day", "day", false, 7, Unit.TIME),
						new Unit("week", "wk", false, 1 , Unit.TIME),
						new Unit("year", "yr", false, 0.0191649555, Unit.TIME)};
		Unit[] forces = {new Unit("newton", "N", true, 1, Unit.FORCE),
						new Unit("pound", "lb", false, 0.224808943, Unit.FORCE)};
		Unit[] pressures = {new Unit("pascal", "Pa", true, 101325, Unit.PRESSURE),
							new Unit("torr", "torr", false, 760, Unit.PRESSURE),
							new Unit("milimeter of mercury", "mmHg", false, 760, Unit.PRESSURE),
							new Unit("bar", "bar", false, 1.01325, Unit.PRESSURE),
							new Unit("pounds per square inch", "PSI", true, 14.69595, Unit.PRESSURE),
							new Unit("atmosphere", "atm", false, 1, Unit.PRESSURE)};
		Unit[] angles = {};
		Unit[] energies = {};
		Unit[] powers = {};
		
		
		JFrame frame = new JFrame("Unit Converter"); // The main frame of the program
		frame.setSize(500, 300);
		JTabbedPane window = new JTabbedPane();
		JComboBox prefix = new JComboBox(prefixes); //Drop down menu of prefixes
		prefix.setSelectedIndex(3); //Sets no prefix as default
		
		//Adding temperature conversions
		JPanel tempPanel = new JPanel();
		JTextField tempInput = new JTextField(5);
		tempPanel.add(tempInput);
		tempPanel.add(prefix);
		JComboBox temps = new JComboBox(temperatures); //Creating temperature drop down menu
		tempPanel.add(temps);
		window.addTab("Temperature", null, tempPanel, "Convert between temperature scales");
		window.setMnemonicAt(0, KeyEvent.VK_1);
		
		//Adding length conversions
		JPanel lenPanel = new JPanel();
		JTextField lenInput = new JTextField(5);
		lenPanel.add(lenInput);
		lenPanel.add(prefix);
		JComboBox lens = new JComboBox(lengths); //Creating length drop down menu
		lenPanel.add(lens);
		window.addTab("Length", null, lenPanel, "Convert between units of length");
		window.setMnemonicAt(1, KeyEvent.VK_2);
		
		frame.add(window, BorderLayout.CENTER);
        frame.setVisible(true);
	}
}
