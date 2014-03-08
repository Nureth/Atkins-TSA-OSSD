package unitConverter;

public class Unit 
{
	private String name;
	private String abbreviation;
	private boolean includeMetricPrefixes;
	private double conversionFactor; //This is equal to the number of this unit in 1 base unit
	private int unitType; //This integer value will be one of the static constant values that indicate what the unit measures
	
	public Unit(String name, String abbreviation, boolean includeMetricPrefixes, double conversionFactor, int unitType)
	{
		this.name = name;
		this.abbreviation = abbreviation;
		this.includeMetricPrefixes = includeMetricPrefixes;
		this.conversionFactor = conversionFactor;
		this.unitType = unitType;
	}
	
	public static final int LENGTH = 0; //Base unit: mile
	public static final int MASS = 1; //Base unit: gram
	public static final int TIME = 2; //Base unit: week
	public static final int FORCE = 3; //Base unit: newton
	public static final int PRESSURE = 4; //Base unit: atmosphere
	public static final int AREA = 5; //Base unit: square meter
	public static final int VOLUME = 6; //Base unit: cubic meter
	public static final int ANGLE = 7; //Base unit: radian
	public static final int ENERGY = 8; //Base unit: joule
	public static final int POWER = 9; //Base unit: watt
	public static final int TEMPERATURE = 10; // Base unit: kelvin. Requires an additional class
	
	public String getName()
	{
		//returns the name of the unit
		return name;
	}
	public String getAbbreviation()
	{
		//returns the abbreviation of the unit
		return abbreviation;
	}
	public boolean includesMetricPrefixes()
	{
		//returns true if the unit can use metric prefixes and false otherwise
		return includeMetricPrefixes;
	}
	public double getConversionFactor()
	{
		//returns the conversion factor
		return conversionFactor;
	}
	public int getUnitType()
	{
		return unitType;
	}
	public double convertTo(double num, Unit other)
	/**
	 * this method converts num of this unit to the unit other and returns the result
	 */
	{
		if (other.getUnitType() != getUnitType())
		{
			return 0; //might be better if it throws some sort of exception, but I don't know how to do that. We shouldn't be trying to convert one type of unit to another anyway.
		}
		double multiplier = (other.getConversionFactor()/ getConversionFactor());
		return (num*multiplier);
	}
	public String toString()
	{
		return name;
	}
	
}
