package com.basic.algorithm;

import java.util.Arrays;

/**
 * 区间重叠问题
 */
public class SectionSolution {
    public boolean canAttendMettions(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
