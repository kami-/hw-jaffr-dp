package com.homework.jaffr.domain.client.state;

import java.util.Random;

import com.homework.jaffr.domain.client.Client;
import com.homework.jaffr.domain.client.ClientState;
import com.homework.jaffr.domain.order.RandomOrderGenerator;

public class OrderingState implements ClientState {

    Random random = new Random();

    public void exec(Client client) {
        client.orderItem(RandomOrderGenerator.nextOrderItem());
        client.setState(getNextState());
        client.doExec();
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
