package utils;

import java.time.LocalDateTime;

public class RandomDataGenerator {

	public static String getUniqueUserName() {
		LocalDateTime dateTime = LocalDateTime.now();

		return "User" + dateTime.getDayOfMonth() + dateTime.getMonthValue() + dateTime.getHour() + dateTime.getMinute();
	}
}
