
/**
 * This is the constructor for the task object
 * 
 * @author Jordan Lever
 *
 */
public class Job implements Comparable<Job> {
	/**
	 * The string containing date
	 */
	private String date;

	/**
	 * The string name
	 */
	private String name;

	/**
	 * This is the constructor that initializes name and date
	 * 
	 * @param name1
	 *            the passed in string name
	 * @param date1
	 *            the passed in date name
	 */
	public Job(String name1, String date1) {
		name = name1;
		date = date1;

	}

	/**
	 * This sets name and data to null
	 */
	public Job() {
		name = null;
		date = null;

	}

	/**
	 * This method gets the task
	 * 
	 * @return the task name
	 */
	public String getTask() {
		return name;
	}

	/**
	 * This method gets the month
	 * 
	 * @return the month
	 */
	public String getDate() {
		return date;
	}

	/**
	 * This is the toStringn function that overrides the java function to print
	 * it out how i want it to
	 * 
	 * @return the String formatted correctly
	 */
	@Override
	public String toString() {
		return name + ", " + date + "\n";
	}

	/**
	 * This is the compare to that sorts the tasks first by date and in case of
	 * a tie by the name of the job.
	 * 
	 * @return 1 if greater than, -1 if less than
	 */
	@Override
	public int compareTo(Job s) {
		date = date.trim();
		String[] split = date.split("/");
		int month = Integer.parseInt(split[0]);
		int day = Integer.parseInt(split[1]);
		String year = split[2];
		String[] split2 = split[2].split(" ");
		int year1 = Integer.parseInt(split2[0]);
		String time = split2[1];
		String[] split3 = time.split(":");
		int hour = Integer.parseInt(split3[0]);
		int minute = Integer.parseInt(split3[1]);

		s.date = s.date.trim();
		String[] split4 = s.date.split("/");
		int m = Integer.parseInt(split4[0]);
		int d = Integer.parseInt(split4[1]);
		String y = split4[2];
		String[] split5 = split[2].split(" ");
		int y1 = Integer.parseInt(split5[0]);
		String t = split5[1];
		String[] split6 = time.split(":");
		int h = Integer.parseInt(split6[0]);
		int min = Integer.parseInt(split6[1]);

		if (year1 == y1) {
			if (month == m) {
				if (day == d) {
					if (hour == h) {
						if (minute == min) {
							if (this.name.compareToIgnoreCase(s.name) == 0) {
								return 0;
							} else if (this.name.compareToIgnoreCase(s.name) < 0) {
								return -1;
							} else {
								return 1;

							}
						} else if (minute < min) {
							return -1;
						} else {
							return 1;

						}
					} else if (hour < h) {
						return -1;
					} else {
						return 1;

					}
				} else if (day < d) {
					return -1;
				} else {
					return 1;

				}
			} else if (month < m) {
				return -1;
			} else {
				return 1;

			}

		} else if (year1 < y1) {
			return -1;
		} else {
			return 1;

		}
	}
}
	