package com.homework.jaffr.domain;

public class DiscountState implements ClientState {

    public void doStuff(Client client) {
        System.out.println("DISCOUNT");
        client.setDiscount();
        client.setState(new OrderingState());
        client.doStuff();
    }

}
