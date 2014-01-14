package com.homework.jaffr.domain.client;

import java.util.Random;

import com.homework.jaffr.domain.client.state.DiscountState;
import com.homework.jaffr.domain.client.state.FinishAndPayOrderState;
import com.homework.jaffr.domain.client.state.LeaveRestaurantState;

public class OrderingState implements ClientState {

    Random random = new Random();

    public void exec(Client client) {
        client.orderItem();
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
