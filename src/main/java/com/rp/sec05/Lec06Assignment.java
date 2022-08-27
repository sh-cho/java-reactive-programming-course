package com.rp.sec05;

import com.rp.courseutil.Util;
import com.rp.sec05.assignment.InventoryService;
import com.rp.sec05.assignment.OrderService;
import com.rp.sec05.assignment.RevenueService;

public class Lec06Assignment {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        orderService.orderStream().subscribe(revenueService.orderStreamConsumer());
        orderService.orderStream().subscribe(inventoryService.orderStreamConsumer());

        inventoryService.inventoryStream().subscribe(Util.subscriber("inventory"));
        revenueService.revenueStream().subscribe(Util.subscriber("revenue"));

        Util.sleepSeconds(60);
    }
}
