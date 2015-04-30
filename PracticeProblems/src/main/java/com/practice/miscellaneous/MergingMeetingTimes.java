package com.practice.miscellaneous;

/**
 Problem -
 Your company built an in-house calendar tool called HiCal. You want to add a feature to see the times in a day when everyone is available.
 To do this, you’ll need to know when any team is having a meeting. In HiCal, a meeting is stored as a tuple of integers (start_time, end_time).
 These integers represent the number of 30-minute blocks past 9:00am.
 For example:
 (2, 3) # meeting from 10:00 – 10:30 am
 (6, 9) # meeting from 12:00 – 1:30 pm
 Write a function condense_meeting_times() that takes an array of meeting time ranges and returns an array of condensed ranges.
 For example, given:
 [(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]
 your function would return:
 [(0, 1), (3, 8), (9, 12)]
 Do not assume the meetings are in order. The meeting times are coming from multiple teams.
 In this case the possibilities for start_time and end_time are bounded by the number of 30-minute slots in a day.
 But soon you plan to refactor HiCal to store times as Unix timestamps (which are big numbers).
 Write something that's efficient even when we can't put a nice upper bound on the numbers representing our time ranges.

 Solution -
 First, we sort our input array of meetings (by start time first, breaking ties with end time) so that any meetings that
 might need to be merged are now next to each-other.
 Then we walk through our sorted meetings from left to right. At each step, either:

 We can merge the current meeting with the previous one, so we do (keeping track of the resulting merged meeting because we might have to merge it again).
 We can't merge the current meeting with the previous one, so we know the previous one can't be merged with any future meetings. We throw it into merged_meetings.
 Since we "hold on to" the result of a merge without throwing it into merged_meetings right away, after our loop we need to make sure to throw the last merged result into merged_meetings before returning.

 * Created by abhi.pandey on 3/10/15.
 */
public class MergingMeetingTimes {

    class Meeting implements Comparable<Object> {
        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Object o) {
            Meeting m = (Meeting) o;
            return (this.startTime > m.startTime) ? 1 : this.startTime < m.startTime ? 0 : -1;
        }
    }


}
