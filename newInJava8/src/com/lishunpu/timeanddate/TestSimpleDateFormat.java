package com.lishunpu.timeanddate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by lishunpu on 2017/5/23.
 */
public class TestSimpleDateFormat {
    public static void main(String[] args) throws Exception{
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//
//        Callable<LocalDate> task = new Callable<LocalDate>() {
//            @Override
//            public LocalDate call() throws Exception {
//                return DateFormatThreadLocal.convert("20161218");
//            }
//        };
//
//        ExecutorService pool = Executors.newFixedThreadPool(10);//创建一个大小为10的线程池
//        List<Future<LocalDate>> results = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            results.add(pool.submit(task));
//        }
//        for (Future<LocalDate> future : results) {
//            System.out.println(future.get());
//        }
//
//        pool.shutdown(); //如果没有，则上面的程序运行完成后jvm不会停止
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

        Callable<LocalDate> task = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20170523", dtf);
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);//创建一个大小为10的线程池
        List<Future<LocalDate>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }
        for (Future<LocalDate> future : results) {
            System.out.println(future.get());
        }

        pool.shutdown(); //如果没有，则上面的程序运行完成后jvm不会停止
    }
}
