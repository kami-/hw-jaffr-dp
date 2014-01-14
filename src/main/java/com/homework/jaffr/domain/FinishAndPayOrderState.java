package com.homework.jaffr.domain;

public class FinishAndPayOrderState implements ClientState {

    public void doStuff(Client client) {
        System.out.println("FINISHANDPAYORDER");
        client.pay();
        client.setState(new WaitingForOrderSate());
        client.doStuff();
    }

}
