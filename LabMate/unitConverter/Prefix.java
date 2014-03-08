package unitConverter;

public class Prefix 
{
	private int value;
	private String name;
	private String abbreviation;
	
	public Prefix(int exponent, String name, String abbreviation)
	{
		value = (int) Math.pow(10, exponent);
		this.name = name;
		this.abbreviation = abbreviation;
	}
	public int getValue()
	{
		return value;
	}
	public String getName()
	{
		return name;
	}
	public String getAbbreviation()
	{
		return abbreviation;
	}
	public String toString()
	{
		return name;
	}
}
