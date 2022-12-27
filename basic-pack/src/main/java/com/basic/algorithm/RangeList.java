package com.basic.algorithm;

import java.util.Arrays;

public class RangeList {

    public void add(int[] addInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int idx = 0;
        // 遍历区间列表：
        // 首先将新区间左边且相离的区间加入结果集
        int i = 0;
        while (i < intervals.length && intervals[i][1] < addInterval[0]) {
            res[idx++] = intervals[i++];
        }
        // 接着判断当前区间是否与新区间重叠，重叠的话就进行合并，直到遍历到当前区间在新区间的右边且相离，
        // 将最终合并后的新区间加入结果集
        while (i < intervals.length && intervals[i][0] <= addInterval[1]) {
            addInterval[0] = Math.min(intervals[i][0], addInterval[0]);
            addInterval[1] = Math.max(intervals[i][1], addInterval[1]);
            i++;
        }
        res[idx++] = addInterval;
        // 最后将新区间右边且相离的区间加入结果集
        while (i < intervals.length) {
            res[idx++] = intervals[i++];
        }

        intervals = Arrays.copyOf(res, idx);
    }
    public void remove(int[] removeInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int idx = 0;
        // 遍历区间列表,四种情况删除：删左，删右，删中，全删；
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= removeInterval[0] && intervals[i][1] <= removeInterval[1]) {
                continue;
            }
            if (intervals[i][0] < removeInterval[0] && intervals[i][1] > removeInterval[1]) {
                res[idx++] = new int[]{intervals[i][0], removeInterval[0]};
                res[idx++] = new int[]{removeInterval[1], intervals[i][1]};
                continue;
            }
            if (intervals[i][0] >= removeInterval[0] && intervals[i][0] < removeInterval[1]) {
                res[idx++] = new int[]{removeInterval[1], intervals[i][1]};
                continue;
            }
            if (intervals[i][1] > removeInterval[0] && intervals[i][1] <= removeInterval[1]) {
                res[idx++] = new int[]{intervals[i][0], removeInterval[0]};
                continue;
            }
            res[idx++] = intervals[i];
        }


        intervals = Arrays.copyOf(res, idx);
    }
    private int[][] intervals={{1,3},{5,6},{7,9},{10,11},{14,20}};
    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] arr : intervals) {
            stringBuilder.append("[").append(arr[0]).append(",").append(arr[1]).append(")");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        RangeList rangeList = new RangeList();
        System.out.println(rangeList.print());
        rangeList.add(new int[]{1,4});
        System.out.println(rangeList.print());
        rangeList.add(new int[]{10,13});
        System.out.println(rangeList.print());
        rangeList.remove(new int[]{1,7});
        System.out.println(rangeList.print());
        rangeList.remove(new int[]{15,17});
        System.out.println(rangeList.print());
        rangeList.remove(new int[]{6,12});
        System.out.println(rangeList.print());
    }
}
