package com.practice.companies.uber;

import java.util.*;

/**
 *
 Given a log of sessions including id, login time, and logout time, produce a time series of the number of logged in users.

 INPUT:
 [
 {
 "id": 2523,
 "login_time": 1432931221,
 "logout_time": 1432931421
 },
 {
 "id": 123415,
 "login_time": 1432931421,
 "logout_time": 1432931621
 },
 {
 "id": 243,
 "login_time": 1432931821,
 "logout_time": 1432931921
 }
 ...
 ]

 OUTPUT:
 [
 {
 "timestamp": 1432931800,
 "count": 120
 },
 {
 "timestamp": 1432931860,
 "count": 130
 },
 ...
 ]
 * Created by abhi.pandey on 5/16/16.
 */
public class IntervalTree {
    public InternalNode insert(InternalNode root, long login_time, long logout_time, int id) {
        if (root == null) {
            InternalNode interval = new InternalNode(login_time, logout_time, id);
            interval.max = logout_time;
            return interval;
        }

        if (login_time < root.login_time) {
            root.left = insert(root.left, login_time, logout_time, id);
        } else {
            root.right = insert(root.right, login_time, logout_time, id);
        }

        root.max = Math.max(root.logout_time, logout_time);

        return root;
    }

    public int getOverlapIntervals(InternalNode root, long timestamp) {
        ArrayList<InternalNode> overlapIntervals = new ArrayList<>();

        Stack<InternalNode> stack = new Stack();

        stack.push(root);

        while (!stack.isEmpty()) {
            InternalNode interval = stack.pop();
            if (interval != null) {
                if (interval.login_time <= timestamp && timestamp < interval.logout_time) {
                    overlapIntervals.add(interval);
                }

                stack.push(interval.left);
                stack.push(interval.right);
            }
        }

        return overlapIntervals.size();
    }

    public long getMinimumTime(InternalNode root) {

        InternalNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                return curr.login_time;
            } else {
                curr = curr.left;
            }
        }

        return curr.login_time;
    }

    public long getMaximumTime(InternalNode root) {

        InternalNode curr = root;

        while (curr != null) {
            if (curr.right == null) {
                return curr.logout_time;
            } else {
                curr = curr.right;
            }
        }

        return curr.logout_time;
    }


}

class InternalNode {

    long login_time;
    long logout_time;

    long max;

    InternalNode left;
    InternalNode right;
    int data;

    public InternalNode(long login_time, long logout_time, int id) {
        this.login_time = login_time;
        this.logout_time = logout_time;
        this.data = id;
    }

}


class Runner {
    private static List<TimeSeriesData> listOfSessions;

    public static void main(String[] args) {
        List<TimeSeriesData> listOfSessions = getListOfSessions();
        IntervalTree it = new IntervalTree();
        InternalNode root = null;
        for (TimeSeriesData t : listOfSessions) {
            root = it.insert(root, t.login_time, t.logout_time, t.id);
        }

        long min = it.getMinimumTime(root);
        long max = it.getMaximumTime(root);

        long interval = 150;

        Map<Long, Integer> mapOfTimeAndCount = new HashMap<>();
        for (long i = min; i < max; ) {
            int count = it.getOverlapIntervals(root, i);
            mapOfTimeAndCount.put(i, count);
            i = i + interval;
        }

        System.out.println(mapOfTimeAndCount);
    }

    public static List<TimeSeriesData> getListOfSessions() {
        listOfSessions = new ArrayList<>();
        int id = 2523;
        long login_time = 1432931221;
        long logout_time = 1432931421;
        TimeSeriesData ts = new TimeSeriesData(id, login_time, logout_time);
        listOfSessions.add(ts);
        id=  123415;
        login_time= 1432931421;
        logout_time =1432931621;
        ts = new TimeSeriesData(id, login_time, logout_time);
        listOfSessions.add(ts);
        id=  243;
        login_time= 1432931821;
        logout_time =1432931921;
        ts = new TimeSeriesData(id, login_time, logout_time);
        listOfSessions.add(ts);
        return listOfSessions;
    }
}

class TimeSeriesData {
    int id;
    long login_time;
    long logout_time;

    public TimeSeriesData(int id, long login_time, long logout_time) {
        this.id = id;
        this.login_time = login_time;
        this.logout_time = logout_time;
    }
}
