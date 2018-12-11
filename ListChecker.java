import java.awt.Color;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ListChecker {
	// private variables
	private ArrayList<CalendarEventClone> aList;
	private Timestamp xStart, xEnd, yStart, yEnd;
	private String xText, yText;
	private Color xColor, yColor;
	
	// constructor for ListChecker
	public ListChecker(ArrayList<CalendarEventClone> list, CalendarEventClone x)
	{
		aList = new ArrayList<CalendarEventClone>();
		aList = list;
		
		// Timestamp Start & End
		xStart = x.getStart();
		xEnd = x.getEnd();
		// String 
		xText = x.getText();
		// Color
		xColor = x.getColor();
	}
	
	public int checkPostion()
	{
		int count = 0;
		while (count < aList.size())
		{
			boolean colorSwitch = false;
			yColor = aList.get(count).getColor();
			if(xColor.getRGB() == yColor.getRGB()) 
			{
				colorSwitch = true;
			}
			yStart = aList.get(count).getStart();
			yEnd = aList.get(count).getEnd();
			yText = aList.get(count).getText();
			if ((xStart.compareTo(yStart) == 0) && (xEnd.compareTo(yEnd) == 0) && (xText.equals(yText)) && (colorSwitch == true))
				break;
			count++;
		}
		return count;
	}
	
	public boolean checkAvailable()
	{
		boolean flag = false;
		for (int count = 0; count < aList.size(); count++)
		{
			boolean colorSwitch = false;
			yColor = aList.get(count).getColor();
			if(xColor.getRGB() == yColor.getRGB()) 
			{
				colorSwitch = true;
			}
			yStart = aList.get(count).getStart();
			yEnd = aList.get(count).getEnd();
			yText = aList.get(count).getText();
			if ((xStart.compareTo(yStart) == 0) && (xEnd.compareTo(yEnd) == 0) && (xText.equals(yText)) && (colorSwitch == true))
				flag = true;
		}
		return flag;
	}
}
