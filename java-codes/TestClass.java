import java.io.*;
import java.util.*;

public class TestClass {
	static class Interval{
		final int startTime;
		final int endTime;
		public Interval(final int startTime, final int endTime){
			this.startTime = startTime;
			this.endTime = endTime;
		}
		public int startTime(){ return this.startTime; }
		public int endTime() { return this.endTime; }
	}
	static int minReservationTables(int[][] reservationStartEndTimes) {
		  if(reservationStartEndTimes == null) return 0;

		  final int noOfReservations = reservationStartEndTimes.length;
		  if(noOfReservations < 1) return 0;
		  if(noOfReservations == 1) return 1;

		  final Interval[] intervals = new Interval[noOfReservations];

          int startTimeCurrent;
		  int endTimeCurrent;

		  for(int i = 0; i < noOfReservations; ++i){
			  startTimeCurrent = reservationStartEndTimes[i][0];
			  endTimeCurrent   = reservationStartEndTimes[i][1];
			  intervals[i]     =  new Interval(startTimeCurrent, endTimeCurrent);
		  }

		  Arrays.<Interval>sort(intervals, 
		                     (firstInterval, secondInterval) -> Integer.compare(firstInterval.startTime(), secondInterval.startTime()));
		  
		  int minReservationTablesNeeded = 1;
		  int noOfTablesNeeded = 1;
		  int lastMaxEndTime = Integer.MIN_VALUE; //[0].endTime();
		  Interval currentReservation;
		  for(int i = 0; i < noOfReservations; ++i) {
			  currentReservation = intervals[i];
			  ++i;
			  while(i < noOfReservations && currentReservation.endTime() > intervals[i].startTime()){
				  ++i;
				  ++noOfTablesNeeded;
			  }
              minReservationTablesNeeded = Math.max(minReservationTablesNeeded , noOfTablesNeeded);
			  if(i >= noOfReservations) break;
		  }

		  return noOfTablesNeeded;

	}

	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] reservationStartEndTimeList = new int[n][2];
		String[] reservationStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] reservationStartEndTime = reservationStartEndTimes[i].split(",");
			for (int j = 0; j < reservationStartEndTime.length; j++) {
				reservationStartEndTimeList[i][j] = Integer.parseInt(reservationStartEndTime[j]);
			}
		}

		int out = minReservationTables(reservationStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}
}
