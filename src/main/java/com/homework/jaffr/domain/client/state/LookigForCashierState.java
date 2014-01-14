package com.homework.jaffr.domain.client.state;

import com.homework.jaffr.domain.client.Client;
import com.homework.jaffr.domain.client.ClientState;
import com.homework.jaffr.domain.client.OrderingState;

public class LookigForCashierState implements ClientState {

    public void exec(Client client) {
        while (!client.hasFoundCashier()) {
            client.lookForFreeCashier();
        }
        client.setState(new OrderingState());
        client.doExec();
    }

}
