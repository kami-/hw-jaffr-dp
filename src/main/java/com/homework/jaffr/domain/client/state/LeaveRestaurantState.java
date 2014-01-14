package com.homework.jaffr.domain.client.state;

import com.homework.jaffr.domain.client.Client;
import com.homework.jaffr.domain.client.ClientState;

public class LeaveRestaurantState implements ClientState {

    public void exec(Client client) {
        client.leave();
    }

}
