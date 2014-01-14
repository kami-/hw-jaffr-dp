package com.homework.jaffr.domain.client.state;

import com.homework.jaffr.domain.client.Client;
import com.homework.jaffr.domain.client.ClientState;

public class FinishAndPayOrderState implements ClientState {

    public void exec(Client client) {
        client.pay();
        client.setState(new WaitingForOrderSate());
        client.doExec();
    }

}
