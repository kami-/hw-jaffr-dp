package com.homework.jaffr.domain.order;

import java.util.Random;

public class RandomOrderGenerator {
    Random random = new Random();

    public static OrderItem nextOrderItem() {
        return new OrderItem();
    }
}
