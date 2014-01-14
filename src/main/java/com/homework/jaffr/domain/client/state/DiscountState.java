package com.homework.jaffr.domain.client.state;

import com.homework.jaffr.domain.client.Client;
import com.homework.jaffr.domain.client.ClientState;
import com.homework.jaffr.domain.client.OrderingState;

public class DiscountState implements ClientState {

    public void exec(Client client) {
        client.setDiscount();
        client.setState(new OrderingState());
        client.doExec();
    }

}
