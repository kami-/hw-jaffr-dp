package com.homework.jaffr.domain.client.state;

import com.homework.jaffr.domain.client.Client;
import com.homework.jaffr.domain.client.ClientState;

public class WaitingForOrderSate implements ClientState {

    public void exec(Client client) {
        while (!client.hasReceivedOrder()) {
        }
        System.out.println("Client received order!");
        client.setState(new LeaveRestaurantState());
        client.doExec();
    }

}
