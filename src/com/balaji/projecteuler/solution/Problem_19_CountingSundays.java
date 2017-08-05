package com.balaji.projecteuler.solution;

/**
 * You are given the following information, but you may prefer to do some
 * research for yourself. <br>
 * <ol>
 * <li>1 Jan 1900 was a Monday.</li>
 * <li>Thirty days has September, April, June and November. All the rest have
 * thirty-one, Saving February alone, Which has twenty-eight, rain or shine. And
 * on leap years, twenty-nine.</li>
 * <li>A leap year occurs on any year evenly divisible by 4, but not on a
 * century unless it is divisible by 400.</li>
 * </ol>
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 * 
 * @author Balaji Rayakota
 */
public class Problem_19_CountingSundays {
	/**
	 * Solution = 171.
	 * 
	 * @param args
	 *           The String array with command line arguments.
	 */
	public static void main(final String[] args) {
		final Date sunday = new Date(31, 12, 1899);
		final Date firstDate = new Date(1, 1, 1901);
		final Date finalDate = new Date(31, 12, 2000);
		int totalMondaysOnFirst = 0;
		for (; sunday.isLessThanOrEqualTo(finalDate); sunday.add(7)) {
			if (!sunday.isLessThanOrEqualTo(firstDate) && sunday.getDate() == 1) {
				System.out.println(sunday);

				totalMondaysOnFirst++;
			}
		}

		System.out.println(totalMondaysOnFirst);
	}

	/**
	 * A Date class which holds date, month, and year.
	 */
	public static class Date {
		private int date;
		private int month;
		private int year;

		/**
		 * Constructor for creating Date.
		 * 
		 * @param date
		 *           The date (must be between 1 and 31).
		 * @param month
		 *           The month (must be between 1 and 12).
		 * @param year
		 *           The year (must be positive).
		 */
		public Date(final int date, final int month, final int year) {
			if (date < 1 || date > 31 || month < 1 || month > 12 || year < 1) {
				throw new IllegalArgumentException("Invalid date. dd =" + date + " mm = " + month + " yy = " + year);
			}

			this.date = date;
			this.month = month;
			this.year = year;
		}

		@Override
		public String toString() {
			return String.format("%2d - %2d - %4d", date, month, year);
		}

		/**
		 * Calculates if this date is less than or equal to supplied date.
		 * 
		 * @param dateCompared
		 *           The {@link Date} to be compared with (cannot be null).
		 * @return True iff this date is less than or equal to supplied date.
		 */
		public boolean isLessThanOrEqualTo(final Date dateCompared) {
			if (dateCompared == null) {
				throw new IllegalArgumentException("Null date was supplied to be compared with");
			}

			if (year != dateCompared.getYear()) {
				return year < dateCompared.getYear();
			}

			if (month != dateCompared.getMonth()) {
				return month < dateCompared.getMonth();
			}

			if (date != dateCompared.getDate()) {
				return date < dateCompared.getDate();
			}

			return true;
		}

		/**
		 * @return date.
		 */
		public int getDate() {
			return date;
		}

		/**
		 * @return month.
		 */
		public int getMonth() {
			return month;
		}

		/**
		 * @return year.
		 */
		public int getYear() {
			return year;
		}

		/**
		 * Add supplied number of days to the current date and returns that. Note:
		 * changes the object.
		 * 
		 * @param days
		 *           The days to be added (must be positive).
		 * @return non-null {@link Date} after adding number of days to be added.
		 */
		public Date add(final int days) {
			if (days < 0) {
				throw new IllegalArgumentException("Negative days to be added was supplied. days = " + days);
			}

			final int tempDate = date + days;
			final int daysInMonth = getDaysInMonth(month, year);

			if (tempDate <= daysInMonth) {
				date = tempDate;
			} else {
				date = tempDate - daysInMonth;
				month = month + 1 == 13 ? 1 : month + 1;
				if (month == 1) {
					year++;
				}
			}

			return this;
		}

		private int getDaysInMonth(final int mm, final int yyyy) {
			final boolean leapYear = isLeapYear(yyyy);
			switch (mm) {
			case 2:
				if (leapYear) {
					return 29;
				}
				return 28;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			default:
				throw new IllegalArgumentException("Invalid month = " + mm);

			}
		}

		private boolean isLeapYear(final int yy) {
			// return (year % 400 == 0) || ((year % 4 == 0) && !(year % 100 == 0));
			if (yy % 4 != 0) {
				return false;
			} else if (yy % 400 == 0) {
				return true;
			} else if (yy % 100 == 0) {
				return false;
			} else {
				return true;
			}
		}
	}
}
