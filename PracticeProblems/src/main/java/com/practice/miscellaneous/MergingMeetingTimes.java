package com.practice.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem -
 * Your company built an in-house calendar tool called HiCal. You want to add a feature to see the times in a day when everyone is available.
 * To do this, you’ll need to know when any team is having a meeting. In HiCal, a meeting is stored as a tuple of integers (start_time, end_time).
 * These integers represent the number of 30-minute blocks past 9:00am.
 * For example:
 * (2, 3) # meeting from 10:00 – 10:30 am
 * (6, 9) # meeting from 12:00 – 1:30 pm
 * Write a function condense_meeting_times() that takes an array of meeting time ranges and returns an array of condensed ranges.
 * For example, given:
 * [(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]
 * your function would return:
 * [(0, 1), (3, 8), (9, 12)]
 * Do not assume the meetings are in order. The meeting times are coming from multiple teams.
 * In this case the possibilities for start_time and end_time are bounded by the number of 30-minute slots in a day.
 * But soon you plan to refactor HiCal to store times as Unix timestamps (which are big numbers).
 * Write something that's efficient even when we can't put a nice upper bound on the numbers representing our time ranges.
 * <p/>
 * Solution -
 * First, we sort our input array of meetings (by start time first, breaking ties with end time) so that any meetings that
 * might need to be merged are now next to each-other.
 * Then we walk through our sorted meetings from left to right. At each step, either:
 * <p/>
 * We can merge the current meeting with the previous one, so we do (keeping track of the resulting merged meeting because we might have to merge it again).
 * We can't merge the current meeting with the previous one, so we know the previous one can't be merged with any future meetings. We throw it into merged_meetings.
 * Since we "hold on to" the result of a merge without throwing it into merged_meetings right away, after our loop we need to make sure to throw the last merged result into merged_meetings before returning.
 * <p/>
 * Created by abhi.pandey on 3/10/15.
 */
public class MergingMeetingTimes {

    public static void main(String[] args) {
        List<Meeting> inputMeetingsList = new ArrayList<>();
        inputMeetingsList.add(new Meeting(-10, -1));
        inputMeetingsList.add(new Meeting(0, 2));
        inputMeetingsList.add(new Meeting(4, 10));
        inputMeetingsList.add(new Meeting(-5, 1));
        // inputMeetingsList.add(new Meeting(9, 10));
        System.out.println(inputMeetingsList);
        System.out.println(mergeMeetings(inputMeetingsList));
    }

    public static List<Meeting> mergeMeetings(List<Meeting> meetings) {
        List<Meeting> mergedMeetings = new ArrayList<>();

        if (meetings.size() > 0) {
            Collections.sort(meetings);
            Meeting first = meetings.get(0);
            for (int i = 1; i < meetings.size(); i++) {
                Meeting second = meetings.get(i);
                if (first.getEndTime() >= second.getStartTime()) {
                    first.setEndTime(Math.max(first.getEndTime(), second.getEndTime()));

                } else {
                    mergedMeetings.add(first);
                    first = second;
                }
            }
            mergedMeetings.add(first);
        }

        return mergedMeetings;
    }

    static class Meeting implements Comparable<Meeting> {

        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meeting m) {
            int compare = this.getStartTime() - m.getStartTime();
            if (compare == 0) {
                compare = this.getEndTime() - m.getEndTime();
            }
            return compare;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    +startTime +
                    ", " + endTime +
                    '}';
        }
    }


}
