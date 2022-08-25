package com.rp.sec04;

import com.rp.courseutil.Util;
import com.rp.sec04.helper.OrderService;
import com.rp.sec04.helper.PurchaseOrder;
import com.rp.sec04.helper.UserService;

import java.io.BufferedReader;

public class Lec12FlatMap {

    public static void main(String[] args) {
        BufferedReader reader;

        UserService.getUsers()
//                .concatMap(user -> OrderService.getOrders(user.getUserId()))
                .flatMap(user -> OrderService.getOrders(user.getUserId())) // mono / flux
                .filter(item -> Double.parseDouble(item.getPrice()) > 50)
//                .doOnDiscard(PurchaseOrder.class, System.out::println)
                .subscribe(Util.subscriber());


        Util.sleepSeconds(60);
    }

}
