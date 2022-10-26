package utils;

import java.time.LocalDateTime;

public class RandomDataGenerator {

	public static String getUniqueUserName() {
		LocalDateTime dateTime = LocalDateTime.now();

		return "User" + Integer.toString(dateTime.getDayOfMonth()) + Integer.toString(dateTime.getMonthValue()) + Integer.toString(dateTime.getHour()) + Integer.toString(dateTime.getMinute());
	}
}
