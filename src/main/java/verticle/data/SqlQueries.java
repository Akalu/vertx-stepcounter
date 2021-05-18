package verticle.data;

public interface SqlQueries {
	
	static String insertStepEvent() {
		return "INSERT INTO step VALUES($1, $2, current_timestamp, $3)";
	}

	static String stepsCountForToday() {
		return "SELECT current_timestamp, coalesce(sum(steps_count), 0) FROM step WHERE " + "(device_id = $1) AND"
				+ "(date_trunc('day', sync_timestamp) = date_trunc('day', current_timestamp))";
	}

	static String totalStepsCount() {
		return "SELECT sum(steps_count) FROM step WHERE" + "(device_id = $1)";
	}

	static String monthlyStepsCount() {
		return "SELECT sum(steps_count) FROM step WHERE" + "(device_id = $1) AND"
				+ "(date_trunc('month', sync_timestamp) = $2::timestamp)";
	}

	static String dailyStepsCount() {
		return "SELECT sum(steps_count) FROM step WHERE" + "(device_id = $1) AND"
				+ "(date_trunc('day', sync_timestamp) = $2::timestamp)";
	}

	static String rankingLast24Hours() {
		return "SELECT device_id, SUM(steps_count) as steps FROM step WHERE"
				+ "(now() - sync_timestamp <= (interval '24 hours'))" + "GROUP BY device_id ORDER BY steps DESC";
	}
}
