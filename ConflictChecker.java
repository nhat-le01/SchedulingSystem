import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
//import java.util.Time;
import java.sql.Timestamp;

public class ConflictChecker {
	// private variables
	private Timestamp xStart, xEnd, yStart, yEnd;
	private String xText, yText;
	private Color xColor, yColor;

	// constructor for ConflictChecker
	public ConflictChecker(CalendarEventClone x, CalendarEventClone y) {
		// Timestamp Start & End
		xStart = x.getStart();
		xEnd = x.getEnd();
		yStart = y.getStart();
		yEnd = y.getEnd();
		// String
		xText = x.getText();
		yText = y.getText();
		// Color
		xColor = x.getColor();
		yColor = y.getColor();
	}

	public boolean check() {
		boolean colorSwitch = false;
		if (xColor.getRGB() == yColor.getRGB()) {
			colorSwitch = true;
		}
		boolean flag = false;
		if ((xStart.compareTo(yStart) == 0) && (xEnd.compareTo(yEnd) == 0) && (xText.equals(yText))
				&& (colorSwitch == true))
			flag = true;
		return flag;
	}
}
