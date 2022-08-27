package com.rp.sec06;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lec06Parallel {

    public static void main(String[] args) {


        Flux.range(1, 30)
                .parallel()
                .runOn(Schedulers.boundedElastic())
                .doOnNext(i -> printThreadName("next " + i))
//                .sequential()
                .subscribe(v -> printThreadName("sub " + v));

//        List<Integer> notThreadSafeList = new ArrayList<>();
//        Flux.range(1, 1000)
//                .parallel()
//                .runOn(Schedulers.parallel())
//                .subscribe(notThreadSafeList::add);
//        System.out.println(notThreadSafeList.size());

//        List<Integer> threadSafeList = Collections.synchronizedList(new ArrayList<>());
//        Flux.range(1, 1000)
//                .parallel()
//                .runOn(Schedulers.parallel())
//                .subscribe(threadSafeList::add);
//        System.out.println(threadSafeList.size());

        Util.sleepSeconds(5);

    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
