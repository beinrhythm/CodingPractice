package com.practice.companies.lendingclub;

import java.util.*;

/**
 * Created by abhi.pandey on 5/10/16.
 */
public class FindMaxInGivenInterval {
    public static void main(String[] args) {
        List<UserUsage> userUsageList = new ArrayList<>();

        UserUsage user1 = new UserUsage(1, "a", 100, 3.00, 4.00);
        UserUsage user2 = new UserUsage(2, "b", 120, 3.30, 4.30);
        UserUsage user3 = new UserUsage(3, "a", 50, 3.45, 4.15);
        UserUsage user4 = new UserUsage(4, "b", 70, 4.15, 5.00);
        userUsageList.add(user1);
        userUsageList.add(user2);
        userUsageList.add(user3);
        userUsageList.add(user4);

        System.out.println("------");
        System.out.println(getMaxUsageUserBetterSol(userUsageList, 2.00, 3.00));
        System.out.println("------");
        System.out.println(getMaxUsageUserBetterSol(userUsageList, 2.30, 3.10));
        System.out.println("------");
        System.out.println(getMaxUsageUserBetterSol(userUsageList, 3.45, 4.00));
        System.out.println("------");
        System.out.println(getMaxUsageUserBetterSol(userUsageList, 4.10, 4.20));
        System.out.println("------");
        System.out.println(getMaxUsageUserBetterSol(userUsageList, 3.45, 4.15));
        System.out.println("------");
        System.out.println(getMaxUsageUserBetterSol(userUsageList, 4.55, 5.30));


    }

   /* O(nlogn) solution using the interval tree https://en.wikipedia.org/wiki/Interval_tree
    this will only take O(nlogn) to build the interval tree. Once build, it will take O(logn) for finding overlapping intervals.
    This is more efficient when you want to maintain the userUsageList
    */
    public static String getMaxUsageUserSol1(List<UserUsage> userUsageList, double startTime, double endTime) {

        HashMap<String, Integer> mapOfUserAndMaxUsage = new HashMap<>();
        IntervalTreeImplementation it = new IntervalTreeImplementation();
        InternalNode root = null;

        for (UserUsage userUsage : userUsageList) {
            root = it.insert(root, userUsage);
        }
        ArrayList<InternalNode> overlapIntervals = it.getOverlapIntervals(root, startTime, endTime);

        for (InternalNode interval : overlapIntervals) {
            if (mapOfUserAndMaxUsage.containsKey(interval.data.username)) {
                mapOfUserAndMaxUsage.put(interval.data.username, mapOfUserAndMaxUsage.get(interval.data.username) + interval.data.cpuUsage);
            } else {
                mapOfUserAndMaxUsage.put(interval.data.username, interval.data.cpuUsage);
            }
        }
        return getMax(startTime, endTime, mapOfUserAndMaxUsage);
    }

    // better O(n) solution, where each user usage entry is matched with the given start and end time if that overlaps
    public static String getMaxUsageUserBetterSol(List<UserUsage> userUsageList, double startTime, double endTime) {

        HashMap<String, Integer> mapOfUserAndMaxUsage = new HashMap<>();

        for (UserUsage userUsage : userUsageList) {
            if ((endTime <= userUsage.endTime && startTime >= userUsage.startTime) ||
                    (endTime < userUsage.endTime && endTime > userUsage.startTime) ||
                    (startTime > userUsage.startTime && startTime < userUsage.endTime)) {

                if (mapOfUserAndMaxUsage.containsKey(userUsage.username)) {
                    mapOfUserAndMaxUsage.put(userUsage.username, mapOfUserAndMaxUsage.get(userUsage.username) + userUsage.cpuUsage);
                } else {
                    mapOfUserAndMaxUsage.put(userUsage.username, userUsage.cpuUsage);
                }
            }
        }
        return getMax(startTime, endTime, mapOfUserAndMaxUsage);
    }

    private static String getMax(double startTime, double endTime, HashMap<String, Integer> mapOfUserAndMaxUsage) {
        StringBuilder sb = new StringBuilder();
        // find user with maximum usage of cpu
        if (!mapOfUserAndMaxUsage.isEmpty()) {
            int maxValueInMap = (Collections.max(mapOfUserAndMaxUsage.values()));  // This will return max value in the Hashmap
            for (Map.Entry<String, Integer> entry : mapOfUserAndMaxUsage.entrySet()) {  // Iterate through hashmap
                if (entry.getValue() == maxValueInMap) {
                    System.out.println("For start time = " + startTime + " and end time = " + endTime + " results - User " +
                            entry.getKey() + " and value " + entry.getValue());     // Print the key with max value

                    sb.append(entry.getKey()).append("=").append(entry.getValue());
                }
            }
        } else {
            System.out.println("No user found for start time = " + startTime + " and end time = " + endTime);
        }

        return sb.toString();
    }
}
