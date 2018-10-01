package question1;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class DaysFromBirth {

	public ZonedDateTime birthday;

	/*
	 * Set a birthday that is used during calculations
	 */
	public DaysFromBirth(ZonedDateTime birthday) {
		this.birthday = birthday;
	}

	/*
	 * Calculates and returns the days from date of birth
	 */
	private int daysElapsedFromBirth() {
		int totalDays = 0;
		ZonedDateTime today = birthday.now();
		int years = today.getYear() - birthday.getYear();
		int days = today.getDayOfYear() - birthday.getDayOfYear();
		totalDays = years * 365 + days;
		int leapYears = 0;
		int yearCheck = birthday.getYear();
		while (yearCheck < today.getYear()) {
			if (yearCheck % 4 == 0) {
				if (yearCheck % 100 == 0 && yearCheck % 400 == 0)
					leapYears++;
				else if (yearCheck % 100 != 0)
					leapYears++;
			}
			yearCheck++;
		}
		totalDays += leapYears;
		return totalDays;
	}

	/*
	 * Used to print in main method
	 */
	public static void sopMain(Object x) {
		System.out.println(x);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		sopMain("Enter your birth year: ");
		String year = in.next();
		sopMain("Enter your birth month in two digits: ");
		String month = in.next();
		sopMain("Enter the day of the month you were born on in two digits: ");
		String date = in.next();
		// timezone and time do not matter
		String birthdayDate = year + "-" + month + "-" + date + "T10:15:30+01:00[Europe/Paris]";
		DaysFromBirth birthday = new DaysFromBirth(ZonedDateTime.parse(birthdayDate));
		System.out.println("Days from your birthday " + birthday.daysElapsedFromBirth());
	}

}
