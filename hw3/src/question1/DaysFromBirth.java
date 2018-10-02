package question1;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DaysFromBirth {
	public static void main(String[] args) {
		// Declare time as 0:0:0.0 as the number of days calculations is affected by
		// duration
		ZonedDateTime myBirthday = ZonedDateTime.of(1999, 3, 31, 0, 0, 0, 0, ZoneId.of("Europe/Paris"));
		// Find duration from myBirthday to the current moment
		Duration time = Duration.between(myBirthday, ZonedDateTime.now());
		System.out.print("I was born on 1999/03/31. Days from my birth " + time.toDays());
	}

}
