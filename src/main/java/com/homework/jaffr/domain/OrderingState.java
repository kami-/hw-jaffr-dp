package com.homework.jaffr.domain;

import java.util.Random;

public class OrderingState implements ClientState {

    Random random = new Random();

    public void doStuff(Client client) {
        System.out.println("ORDERING");
        client.orderItem();
        client.setState(getNextState());
        client.doStuff();
    }

    private ClientState getNextState() {
        int percent = random.nextInt(100);
        ClientState nextState = new OrderingState();
        if (percent < 5) {
            nextState = new LeaveRestaurantState();
        } else if (percent < 10) {
            nextState = new DiscountState();
        } else if (percent < 25) {
            nextState = new FinishAndPayOrderState();
        }
        return nextState;
    }

}
