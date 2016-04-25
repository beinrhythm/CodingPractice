package com.practice.companies.linkedin;

import java.util.List;

/**
 * Given a nested list of integers, returns the sum of all integers in the list weighted by their depth
 * For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1)
 * Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3)
 * <p/>
 * /**
 * Given a nested list of integers, returns the sum of all integers in the list weighted by their reversed depth.
 * For example, given the list {{1,1},2,{1,1}} = {1,1,{2}, 1,1} the deepest level is 2. Thus the function should return 8 (four 1's with weight 1, one 2 with weight 2)
 * Given the list {1,{4,{6}}} the function should return 17 (one 1 with weight 3, one 4 with weight 2, and one 6 with weight 1)
 * <p/>
 * 3x + 2y + z = 4(x + y + z) - (x + 2y + 3z)
 * Created by abhi.pandey on 4/8/16.
 * <p/>
 * This is the interface that represents nested lists.
 * You should not implement it, or speculate about its implementation.
 */
public interface NestedInteger {
    /**
     * @return true if this NestedInteger holds a single integer, rather than a nested list
     */
    boolean isInteger();

    /**
     * @return the single integer that this NestedInteger holds, if it holds a single integer
     * Return null if this NestedInteger holds a nested list
     */
    Integer getInteger();

    /**
     * @return the nested list that this NestedInteger holds, if it holds a nested list
     * Return null if this NestedInteger holds a single integer
     */
    List<NestedInteger> getList();
}

class NestedIntegerSolution {
    public int depthSum(List<NestedInteger> input) {
        return depthSumHelper(input, 1);
    }

    private int depthSumHelper(List<NestedInteger> input, int depth) {
        int sum = 0;
        // look at each nested integer
        for (NestedInteger nestedInteger : input) {
            if (nestedInteger.isInteger()) {
                sum += nestedInteger.getInteger() * depth;
            } else {
                sum += depthSumHelper(nestedInteger.getList(), depth + 1);
            }
        }
        return sum;
    }

    private int sumOfReverse(List<NestedInteger> input) {
        int depth = getDepth(input);
        return reverseDepthSumHelper(input, depth);
    }

    private int reverseDepthSumHelper(List<NestedInteger> input, int depth) {
        int sum = 0;
        // look at each nested integer
        for (NestedInteger nestedInteger : input) {
            if (nestedInteger.isInteger()) {
                sum += nestedInteger.getInteger() * depth;
            } else {
                sum += depthSumHelper(nestedInteger.getList(), depth - 1);
            }
        }
        return sum;
    }

    private int getDepth(List<NestedInteger> input) {
        int depth = 0;
        for (NestedInteger nestedInteger : input) {
            if (!nestedInteger.isInteger()) {
                depth = Math.max(depth, getDepth(nestedInteger.getList()));
            }
        }
        return depth + 1;
    }


}

