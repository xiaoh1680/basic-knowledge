package com.basic.time;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @description:
 * @date: 2018/7/11 14:29
 * @author: xiaohui
 * @projectName: basic-knowledge
 */
public class JudgeRules {
    private static String nottime = "2018-03-05至2018-03-09,2018-04-05至2018-04-09,2018-05-05至2018-05-09,2018-06-05至2018-06-09,";
    private static String time = "2018-03-05至2018-03-09,2018-04-05至2018-04-09,2018-05-05至2018-05-09,2018-06-05至2018-06-09";
    private static String week = "0,1,2,3,4,5";

    public static void main(String[] args) {
        String[] notimes = nottime.split(",");
        for (int i = 0; i < notimes.length; i++) {
            String[] day = notimes[i].split("至");
            LocalDate startdate=LocalDate.parse(day[0]);
            LocalDate endDate = LocalDate.parse(day[1]);
            LocalDate roomDay = LocalDate.parse("2018-12-12");
            LocalDate endRoomDay = LocalDate.parse("2018-12-15");
            LocalDate plus=roomDay.plusDays(1);
            boolean a=startdate.isAfter(roomDay);
            DayOfWeek dayOfWeek=startdate.getDayOfWeek();
            System.out.printf(dayOfWeek.ordinal()+"");
        }

    }
}
