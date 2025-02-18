package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Lec06FluxGenerateAssignment {

    public static void main(String[] args) {

        // canada
        // max = 10
        // subscriber cancels - exit

        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("emitting " + country);
            synchronousSink.next(country);
            if(country.equalsIgnoreCase("canada"))
                synchronousSink.complete();
        })
        .subscribe(Util.subscriber());


    }


}
