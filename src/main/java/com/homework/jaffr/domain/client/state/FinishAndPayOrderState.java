package com.homework.jaffr.domain.client.state;

import com.homework.jaffr.domain.client.Client;
import com.homework.jaffr.domain.client.ClientState;

public class FinishAndPayOrderState implements ClientState {

    public void exec(Client client) {
        client.finishOrder();
        client.payOrder();
        client.setState(new WaitingForOrderSate());
        client.doExec();
    }

}
