package unitConverter;

public class Temperature extends Unit
{
	private double minimum; // represents the lowest possible number for this temperature scale
	private double difference; //Represents the number that must be added or subtracted AFTER division in order to get Kelvin
	public Temperature(String name, String abbreviation, double conversionFactor, double difference, double min)
	{
		super(name, abbreviation, false, conversionFactor, Unit.TEMPERATURE);
		this.difference = difference;
		minimum = min;
	}
	
	public double getDifference()
	{
		return difference;
	}
	public double convertToKelvin(double value)
	{
		if (value < minimum)
		{
			//return error
		}
		return (value*getConversionFactor() + difference);
	}
	public double convertFromKelvin(double value)
	{
		if (value<0)
		{
			//return error 
		}
		return ((value-difference)/getConversionFactor());
	}
	public double getMinimum()
	{
		return minimum;
	}
	public double convertTo(double num, Temperature other)
	/**
	 * this method converts num in this temperature scale to the other temperature scale and returns the result
	 */
	{
		double kelvin = convertToKelvin(num);
		double result = other.convertFromKelvin(kelvin);
		return result;
	}
}
