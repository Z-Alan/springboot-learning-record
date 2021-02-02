package com.example.mybatis.util;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * .
 *
 * @author zhouqiang
 * @date 2021/1/7
 */
public class DateUtilsTest {

    @Test
    public void test() {
        String time = "2020-12-31 12:40:55";
        boolean afterTimeWithNow =
                LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                        .isAfter(LocalDateTime.now());
        boolean beforeTimeWithNow =
                LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                        .isBefore(LocalDateTime.now());
        boolean beforeNowTimeWithNow = LocalDateTime.now().isBefore(LocalDateTime.now());
        System.out.println(afterTimeWithNow);
        System.out.println(beforeTimeWithNow);
        System.out.println(beforeNowTimeWithNow);
    }

    @Test
    public void dateTest() {
        // 19
        demo2("2021-01-19 17:30:00", "2021-01-20 03:00:00");
        // 20
        demo2("2021-01-20 06:30:00", "2021-01-20 08:30:00");
        demo2("2021-01-20 17:30:00", "2021-01-21 01:00:00");
        // 21
//        demo2("2021-01-21 01:30:00", "2021-01-21 08:30:00");
        demo2("2021-01-21 17:30:00", "2021-01-22 03:30:00");
        // 22
        demo2("2021-01-22 04:30:00", "2021-01-22 08:30:00");
        demo2("2021-01-22 17:30:00", "2021-01-22 20:00:00");
        // 23
        demo2("2021-01-23 17:30:00", "2021-01-24 03:00:00");
        // 24
        demo2("2021-01-24 05:00:00", "2021-01-24 08:30:00");
        demo2("2021-01-24 17:30:00", "2021-01-25 03:00:00");

    }


    private void demo2(String start, String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.parse(start, formatter);
        LocalDateTime endTime = LocalDateTime.parse(end, formatter);
        Long during = Duration.between(startTime, endTime).toHours();
        System.out.println(String.format("%s - %s", startTime.toString(), endTime.toString()));
        System.out.println(during);
    }
}
