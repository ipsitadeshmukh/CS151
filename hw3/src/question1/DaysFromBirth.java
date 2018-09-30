package question1;

import java.time.ZonedDateTime;

public class DaysFromBirth{

	public ZonedDateTime birthday;
	
	public DaysFromBirth(ZonedDateTime birthday) {
		this.birthday = birthday;
	}
	
	private int daysElapsedFromBirth() {
		int totalDays=0;
		ZonedDateTime today = birthday.now();
		System.out.println(today);
		int years = today.getYear() - birthday.getYear();
		int days = today.getDayOfYear() - birthday.getDayOfYear();
		totalDays = years*365 + days;
		int leapYears = 0;
		int yearCheck = birthday.getYear();
		while(yearCheck < today.getYear()) {
			if(yearCheck%4 == 0)
			{
				if(yearCheck%100 == 0 && yearCheck%400==0)
					leapYears++;
				else if(yearCheck%100 != 0)
					leapYears++;
			}
			yearCheck++;
		}
		totalDays += leapYears;
		return totalDays;
	}
	
	public static void main(String[] args) {
		DaysFromBirth aaj = new DaysFromBirth(ZonedDateTime.parse("1999-03-31T10:15:30+01:00[Europe/Paris]"));
		System.out.println(aaj.daysElapsedFromBirth());
	}
	
}
