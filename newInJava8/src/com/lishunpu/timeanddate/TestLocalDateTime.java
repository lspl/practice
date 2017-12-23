package com.lishunpu.timeanddate;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by lishunpu on 2017/5/23.
 */
public class TestLocalDateTime {

    //1. LocalDate, LocalTime, LocalDateTime
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.of(2016,5,12,23,22,21);
        System.out.println(ldt2);

        ldt2 = ldt2.plusMinutes(10);
        System.out.println(ldt2);

        ldt2 = ldt2.minusMonths(3);
        System.out.println(ldt2);

        System.out.println(ldt2.getYear());
        System.out.println(ldt2.getMonthValue());
        System.out.println(ldt2.getDayOfMonth());
        System.out.println(ldt2.getHour());
        System.out.println(ldt2.getMinute());
        System.out.println(ldt2.getSecond());
    }

    //2. Instant: 时间戳（以Unix元年：1970年1月1日 00:00:00到某个时间之间的毫秒值）
    @Test
    public void test2() {
        Instant ins1 = Instant.now();//默认获取UTC时区
        System.out.println(ins1);

        OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        System.out.println(ins1.toEpochMilli());//获取时间戳

        Instant ins2 = Instant.ofEpochSecond(60); //相对于Unix元年的时间偏移
        System.out.println(ins2);
    }

    //3. Duration: 计算两个“时间”之间的间隔
    @Test
    public void test3() {
        Instant ins1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (Exception e){
        }
        Instant ins2 = Instant.now();
        Duration d = Duration.between(ins1, ins2);
        System.out.println(d.toMillis());

        LocalTime lt1 = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        LocalTime lt2 = LocalTime.now();
        System.out.println(Duration.between(lt1, lt2).toMillis());
    }

    //3 Period： 计算两个“日期”之间的间隔
    @Test
    public void test4() {
        LocalDate ld1 = LocalDate.of(2015,2,3);
        LocalDate ld2 = LocalDate.now();

        Period period = Period.between(ld1, ld2);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

    //时间校正器
    @Test
    public void test5() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        //自定义下一个工作日
        LocalDateTime ldt5 = ldt.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;
            DayOfWeek dow = ldt4.getDayOfWeek();

            if(dow.equals(DayOfWeek.FRIDAY)) {
                return ldt4.plusDays(3);
            } else if (dow.equals(DayOfWeek.MONDAY)) {
                return ldt4.plusDays(2);
            } else {
                return ldt4.plusDays(1);
            }
        });

        System.out.println(ldt5);
    }

    //DateTimeFormatter: 格式化时间/日期
    @Test
    public void test6() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();

        String strDate = ldt.format(dtf);
        System.out.println(strDate);

        System.out.println("----------------------------------");

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate2 = dtf2.format(ldt);
        System.out.println(strDate2);

        LocalDateTime newDate = ldt.parse(strDate2, dtf2);
        System.out.println(newDate);
    }

    //ZonedDate, ZonedTime, ZonedDateTime
    @Test
    public void test8() {
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt);
    }
}
